package com.exam.spring.project.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 超市员工基本信息表
 */
@Data
public class PersonInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 员工id（唯一id，自动生成）
     */
    private String personId;
    /**
     * 职位
     */
    private Integer type;
    /**
     * 邮箱
     */
    private String email;
}
