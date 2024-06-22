package com.exam.spring.project.service.impl;

import com.exam.spring.project.entity.PersonInfo;
import com.exam.spring.project.mapper.PersonInfoMapper;
import com.exam.spring.project.service.DemoService;
import com.exam.spring.project.service.PersonInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    private PersonInfoService personInfoService;

    /**
     * 查询所有
     */
    @Override
    public List<PersonInfo> getAll() {
        return personInfoService.query().list();
    }
}
