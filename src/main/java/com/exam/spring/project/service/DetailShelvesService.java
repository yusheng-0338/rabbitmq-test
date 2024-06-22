package com.exam.spring.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.spring.project.entity.DetailShelves;
import com.exam.spring.project.entity.GoodsDetail;
import com.exam.spring.project.entity.PersonInfo;

import java.util.List;

public interface DetailShelvesService extends IService<DetailShelves> {


    /**
     * 绑定商品和货架关系
     * @param detailShelves
     */
    boolean addDetailShelves(DetailShelves detailShelves);
}
