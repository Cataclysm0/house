package com.pzhu.house.service.city.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzhu.house.mapper.city.ChinaMapper;
import com.pzhu.house.model.entity.city.China;
import com.pzhu.house.service.city.IChinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 中国城市表 服务实现类
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
@Service
public class ChinaServiceImpl extends ServiceImpl<ChinaMapper, China> implements IChinaService {

    @Autowired
    private ChinaMapper chinaMapper;

    @Override
    public List<China> getProvinceList() {
        return chinaMapper.selectList(new QueryWrapper<China>().isNull("pid"));
    }
}
