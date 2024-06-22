//package com.exam.spring.demo.service.impl;
//
//import cn.hutool.core.util.IdUtil;
//import com.exam.spring.demo.entity.HeadEntity;
//import com.exam.spring.demo.mapper.HeadMapper;
//import com.exam.spring.demo.service.HeadService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * @description:
// * @date: 2023-08-07
// */
//@Service
//public class HeadServiceImpl implements HeadService {
//    @Autowired
//    private HeadMapper headMapper;
//
//    @Override
//    public void save(HeadEntity entity) {
//        entity.setUid(IdUtil.simpleUUID());
//        headMapper.save(entity);
//    }
//
//    @Override
//    public HeadEntity getById(String uid) {
//        return headMapper.getId(uid);
//    }
//}
