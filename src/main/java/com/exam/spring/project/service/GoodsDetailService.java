package com.exam.spring.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.spring.project.entity.GoodsDetail;
import com.exam.spring.project.entity.PersonInfo;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GoodsDetailService extends IService<GoodsDetail> {



    boolean purchase(List<GoodsDetail> list);


    /**
     * 添加商品信息
     * @param goodsDetail
     * @return
     */
    boolean addGoodDetail(GoodsDetail goodsDetail);


    boolean MergeInterfaces(List<GoodsDetail> list) throws InterruptedException;

    boolean updateGoodsDetailList(List<GoodsDetail> list) throws InterruptedException;
}
