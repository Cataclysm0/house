package com.pzhu.house.service.city.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzhu.house.mapper.city.RegionMapper;
import com.pzhu.house.model.entity.city.Region;
import com.pzhu.house.service.city.IRegionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 大区表 服务实现类
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements IRegionService {

}
