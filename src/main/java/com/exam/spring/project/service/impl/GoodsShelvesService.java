package com.exam.spring.project.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.spring.project.entity.GoodsShelves;

import com.exam.spring.project.mapper.GoodsShelvesMapper;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class GoodsShelvesService extends ServiceImpl<GoodsShelvesMapper, GoodsShelves> implements com.exam.spring.project.service.GoodsShelvesService {

    @Resource
    private GoodsShelvesMapper goodsShelvesMapper;

    /**
     * 批量添加货架
     *
     * @param list
     */
    @Override
    public boolean addGoodShelves(List<GoodsShelves> list) {
        // 1.遍历list
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setGoodsShelvesNo(generateGoodsShelvesNo(i));
        }

        // 3.批量插入
        return this.saveBatch(list);
    }

    /**
     * 生成货架编号
     *
     * @return
     */
    private String generateGoodsShelvesNo(int i) {
        // 获取当前日期
        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

//        // 查询当天已有的最大流水号
//        List<GoodsShelves> list = this.query().lt("create_time", new Date()).orderByDesc("create_time").list();
//        // 当天最大流水号
//        if (list.size() == 0){
//            return currentDate + "0001";
//        }
//
//
//
//
//
//        GoodsShelves goodsShelves = list.get(0);
//        String goodsShelvesNo = goodsShelves.getGoodsShelvesNo();
//        int number = Integer.parseInt(goodsShelvesNo.substring(8));
//        number = number + i + 1;
//        // 重新组装流水号
//        String formattedNumber = String.format("%04d", number);
//        return currentDate + formattedNumber;


        Integer maxSerialNumber = goodsShelvesMapper.getMaxSerialNumberForDate(currentDate);
        int newSerialNumber = (maxSerialNumber != null ? maxSerialNumber : 0) + i + 1;

        // 生成货架编号
        return currentDate + String.format("%04d", newSerialNumber);
    }

}
