package com.exam.spring.project.controller;

import com.exam.spring.project.entity.DetailShelves;
import com.exam.spring.project.entity.GoodsDetail;
import com.exam.spring.project.entity.GoodsShelves;
import com.exam.spring.project.entity.PersonInfo;
import com.exam.spring.project.in.DCashRegister;
import com.exam.spring.project.service.DemoService;
import com.exam.spring.project.service.DetailShelvesService;
import com.exam.spring.project.service.GoodsDetailService;
import com.exam.spring.project.service.GoodsShelvesService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "demo")
public class DemoController {

    @Resource
    private DemoService demoService;

    @Resource
    private GoodsShelvesService goodsShelvesService;

    @Resource
    private DetailShelvesService detailShelvesService;

    @Resource
    private GoodsDetailService goodsDetailService;

    @RequestMapping("/hello")
    public List<PersonInfo> hello(){
        return demoService.getAll();
    }

    /**
     * 批量添加货架
     * @param list
     * @return
     */
    @PostMapping("/addGoodShelves")
    public Boolean addGoodShelves(@RequestBody List<GoodsShelves> list){
        //店长批量添加货架信息
        return goodsShelvesService.addGoodShelves(list);
    }

    /**
     * 添加商品信息
     * @param goodsDetail
     * @return
     */
    @PostMapping("/addGoodDetail")
    public boolean addGoodDetail(@RequestBody GoodsDetail goodsDetail){
        //由商家指定商品信息的添加
        return goodsDetailService.addGoodDetail(goodsDetail);
    }


    /**
     * 绑定商品和货架关系
     * @return
     */
    @PostMapping("/addDetailShelves")
    public Boolean addDetailShelves(@RequestBody DetailShelves detailShelves){
        //由店员指定该商品上架在哪个货架上
        return detailShelvesService.addDetailShelves(detailShelves);
    }

    /**
     * 用户购买商品
     * @return
     */
    @PostMapping("/MergeInterfaces")
    public Boolean MergeInterfaces(@RequestBody List<GoodsDetail> list) throws InterruptedException {
        //1.由于此处涉及到金额的运算,调用到收银系统的运算接口,需要保证事物的一致性,做到同时成功失败时同时回滚
        //同步修改数据库
        boolean purchase = goodsDetailService.MergeInterfaces(list);
        //

        //获取到数据,遍历



        //2.用户购买成功后,需要判断库存数量是否小于指定额度,若小于指定额度,需要异步去调用邮件分发的接口通知店长补货,
        // 考虑到客流量大,可以采用mq进行异步,解耦,削峰的方式进行分发
        return true;
    }


    @GetMapping ("/login/{username}/{password}")
    public String login(@PathVariable String username, @PathVariable String password){
        return demoService.login(username, password);
    }





}
