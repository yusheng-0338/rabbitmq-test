package com.exam.spring.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.spring.project.entity.GoodsDetail;
import com.exam.spring.project.entity.PersonInfo;
import com.exam.spring.project.mapper.GoodsDetailMapper;
import com.exam.spring.project.mapper.PersonInfoMapper;
import com.exam.spring.project.service.DemoService;
import com.exam.spring.project.service.GoodsDetailService;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class GoodsDetailServiceImpl extends ServiceImpl<GoodsDetailMapper, GoodsDetail> implements GoodsDetailService {

    @Resource
    private RabbitTemplate rabbitTemplate;


    @Value("${app.value}")
    private String num;

    /**
     * 添加商品信息
     *
     * @param goodsDetail
     * @return
     */
    @Override
    public boolean addGoodDetail(GoodsDetail goodsDetail) {
        GoodsDetail detail = query().eq("material_no", goodsDetail.getMaterialNo()).one();
        if (null == detail) {
            return false;

        }
        save(goodsDetail);
        return true;
    }

    @Override
    public boolean purchase(List<GoodsDetail> list) {


        return true;
    }

    /**
     * 添加商品信息
     *
     * @param list
     * @return
     */
    @Override
    @Transactional
    public boolean MergeInterfaces(List<GoodsDetail> list) throws InterruptedException {
        //支付
        this.purchase(list);
        //扣除库存
        this.updateGoodsDetailList(list);

        return true;

    }




    /**
     * 修改库存
     *
     * @param list
     * @return
     */
    @Override
    public boolean updateGoodsDetailList(List<GoodsDetail> list) throws InterruptedException {

        for (GoodsDetail detail : list) {
            // 查询商品信息
            GoodsDetail goodsDetail = query().eq("material_no", detail.getMaterialNo()).one();
            //现有库存
            BigDecimal quantity = goodsDetail.getQuantity();
            // 修改库存
            BigDecimal subtract = quantity.subtract(detail.getQuantity());
            goodsDetail.setQuantity(subtract);
            // 修改库存
//            this.update().eq("material_no", goodsDetail.getMaterialNo()).update(goodsDetail);
            this.updateById(goodsDetail);
            // 判断
            BigDecimal bigDecimal = new BigDecimal(num);

                if (subtract.compareTo(bigDecimal)<=0){
                    //mq消息发送方法

//                    rabbitTemplate.convertAndSend("dircet.exchange","aaaa", goodsDetail.getGoodsName()+"库存不足,请及时补货");
                    testSendMessage2SimpleQueue(goodsDetail);
                }


        }


        return true;
    }


    /*
     * ConfirmCallback可以在发送消息时指定，因为每个业务处理confirm成功或失败的逻辑不一定相同
     */
    public void testSendMessage2SimpleQueue(GoodsDetail goodsDetail) throws InterruptedException {
        // 1.消息体
        String message = "hello, spring amqp!";
        // 2.全局唯一的消息ID，需要封装到CorrelationData中
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        // 3.添加callback
        correlationData.getFuture().addCallback(result -> {
                    if(result.isAck()){
                        // 3.1.ack，消息成功
                        System.out.println("消息发送成功, ID:" + correlationData.getId());
                    }else{
                        // 3.2.nack，消息失败
                        System.out.println("消息发送失败, ID:{}, confirm原因{}" + correlationData.getId() + "reason:" + result.getReason());
                    }
                },
                ex -> System.out.println("消息发送异常, ID:{}, confirm原因{}" + correlationData.getId() + "reason:" + ex.getMessage())
        );
        // 4.发送消息
        rabbitTemplate.convertAndSend("dircet.exchange1","aaa", goodsDetail.getGoodsName()+"库存不足,请及时补货",correlationData);

        // 休眠一会儿，等待ack回执
        Thread.sleep(2000);
    }


}
