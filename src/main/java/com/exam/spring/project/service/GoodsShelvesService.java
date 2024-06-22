package com.exam.spring.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.spring.project.entity.GoodsShelves;
import com.exam.spring.project.entity.PersonInfo;

import java.util.List;

public interface GoodsShelvesService extends IService<GoodsShelves> {


    /**
     * 批量添加货架
     * @param list
     */
    boolean addGoodShelves(List<GoodsShelves> list);
}
