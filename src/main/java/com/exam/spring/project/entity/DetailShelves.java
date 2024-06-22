package com.exam.spring.project.entity;

import lombok.Data;

/**
 * 商品货架关联关系表
 */
@Data
public class DetailShelves {
    /**
     * id
     */
    private String id;
    /**
     * 商品id
     */
    private String materialNo;
    /**
     * 货架id
     */
    private String goodsShelvesNo;
}
