package com.exam.spring.project.in;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 收銀入參
 */
@Data
public class DCashRegister {
    /**
     * 商品料号（手动输入，同本货架下，商品料号唯一）
     */
    private String materialNo;
    /**
     * 单价（手动输入，小数点4位）
     */
    private BigDecimal price;
    /**
     * 数量（手动输入，小数点2位）
     */
    private BigDecimal quantity;
}
