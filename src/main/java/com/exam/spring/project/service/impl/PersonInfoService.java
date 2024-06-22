package com.exam.spring.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.spring.project.entity.PersonInfo;
import com.exam.spring.project.mapper.PersonInfoMapper;
import com.exam.spring.project.service.DemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonInfoService extends ServiceImpl<PersonInfoMapper, PersonInfo> implements com.exam.spring.project.service.PersonInfoService {

}
