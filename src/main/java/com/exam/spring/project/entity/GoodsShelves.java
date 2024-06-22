package com.exam.spring.project.entity;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 货架基本信息表
 */
@Data
public class GoodsShelves implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 货架编号（年月日+4位流水号，代码自动生成，不能重复）
     */

    private String goodsShelvesNo;
    /**
     * 货架类型（食品货架、员工货架、饮料货架）
     */
    private Integer goodsShelvesType;
    /**
     * 物品总价（表体数量*单价的汇总）
     */
    private BigDecimal dclTotalPrice;
    /**
     * 责任人
     */
    private String contactName;
    /**
     * 责任人电话
     */
    private String contactNumber;
    /**
     * 备注
     */
    private String remark;
}
