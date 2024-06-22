package com.exam.spring.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exam.spring.project.entity.GoodsDetail;
import com.exam.spring.project.entity.PersonInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonInfoMapper extends BaseMapper<PersonInfo> {

    /**
     * 查询所有
     * @return
     */
    List<PersonInfo> getAll();
}
