package com.exam.spring.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.spring.project.entity.DetailShelves;
import com.exam.spring.project.entity.GoodsDetail;
import com.exam.spring.project.mapper.DetailShelvesMapper;
import com.exam.spring.project.mapper.GoodsDetailMapper;
import com.exam.spring.project.service.DetailShelvesService;
import com.exam.spring.project.service.GoodsDetailService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailShelvesServiceImpl extends ServiceImpl<DetailShelvesMapper, DetailShelves> implements DetailShelvesService {
    /**
     * 绑定商品和货架关系
     *
     * @param detailShelves
     */
    @Override
    public boolean addDetailShelves(DetailShelves detailShelves) {
        DetailShelves result = query().eq("material_no", detailShelves.getMaterialNo()).eq("goods_shelves_no", detailShelves.getGoodsShelvesNo()).one();
        if (null != result){
            return false;
        }
        save(detailShelves);
        return true;
    }
}
