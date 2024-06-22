package com.exam.spring.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exam.spring.project.entity.GoodsDetail;
import com.exam.spring.project.entity.GoodsShelves;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GoodsShelvesMapper extends BaseMapper<GoodsShelves> {


    int getMaxSerialNumberForDate(String date);
}
