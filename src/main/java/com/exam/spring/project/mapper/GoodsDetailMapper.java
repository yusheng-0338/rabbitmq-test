package com.exam.spring.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exam.spring.project.entity.GoodsDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.stream.BaseStream;

@Mapper
public interface GoodsDetailMapper extends BaseMapper<GoodsDetail> {
}
