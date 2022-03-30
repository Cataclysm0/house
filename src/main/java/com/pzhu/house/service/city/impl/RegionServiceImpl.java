package com.pzhu.house.service.city.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzhu.house.mapper.city.RegionMapper;
import com.pzhu.house.entity.city.Region;
import com.pzhu.house.service.city.IRegionService;
import com.pzhu.house.utils.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

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

    @Autowired
    private RegionMapper regionMapper;

    @Autowired
    private RedisCache redisCache;

    @Override
    public List<Region> getAllRegions() {
        List<Region> region = redisCache.getCacheList("region");
        if (ObjectUtils.isEmpty(region)) {
            region = regionMapper.selectList(null);
            redisCache.setCacheList("region", region);
        }
        return region;
    }
}
