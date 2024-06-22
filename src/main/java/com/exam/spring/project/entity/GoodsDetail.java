package com.exam.spring.project.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 物品基本信息表
 */
@Data
@TableName("goods_detail")
public class GoodsDetail implements Serializable {
//    private static final long serialVersionUID = 1L;
    /**
     * 商品料号（手动输入，同本货架下，商品料号唯一）
     */
    @TableId("material_no")
    private String materialNo;
    /**
     * 商品名称（手动输入）
     */
    @TableField("goods_name")
    private String goodsName;
    /**
     * 单价（手动输入，小数点4位）
     */
    @TableField("price")
    private BigDecimal price;
    /**
     * 数量（手动输入，小数点2位）
     */
    @TableField("quantity")
    private BigDecimal quantity;
    /**
     * 序号（流水号，从1开始，不断号）
     */
    @TableField("serial_no")
    private String serialNo;
}
