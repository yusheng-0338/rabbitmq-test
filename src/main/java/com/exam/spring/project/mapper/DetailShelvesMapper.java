package com.exam.spring.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exam.spring.project.entity.DetailShelves;
import com.exam.spring.project.entity.GoodsDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DetailShelvesMapper extends BaseMapper<DetailShelves> {
}
