package com.exam.spring.project.service;

import com.exam.spring.project.entity.PersonInfo;

import java.util.List;

public interface DemoService {

    /**
     * 查询所有
     */
    public List<PersonInfo> getAll();

}
