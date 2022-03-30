package com.pzhu.house.service.city.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzhu.house.mapper.city.ChinaMapper;
import com.pzhu.house.mapper.city.RegionCityMapper;
import com.pzhu.house.entity.city.China;
import com.pzhu.house.entity.city.RegionCity;
import com.pzhu.house.service.city.IChinaService;
import com.pzhu.house.utils.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
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

    @Autowired
    private RegionCityMapper regionCityMapper;

    @Autowired
    private RedisCache redisCache;

    @Override
    public List<China> getAllProvinceList() {
        return chinaMapper.selectList(new QueryWrapper<China>().isNull("pid"));
    }

    @Override
    public List<China> getCityListByProvinceId(Long provinceId) {
        List<China> cityList = redisCache.getCacheList("province_id:" + provinceId);
        if (ObjectUtils.isEmpty(cityList)) {
            cityList = chinaMapper.selectList(new QueryWrapper<China>().eq("pid", provinceId));
            redisCache.setCacheList("province_id:" + provinceId, cityList);
        }
        return cityList;
    }

    @Override
    public List<China> getCityListByRegionId(Long regionId) {
        List<China> cityList = redisCache.getCacheList("region_id:" + regionId);
        if (ObjectUtils.isEmpty(cityList)) {
            List<RegionCity> cityIdList = regionCityMapper.selectList(new QueryWrapper<RegionCity>().eq("region_id", regionId));
            ArrayList<Long> cityIds = new ArrayList<>();
            for (RegionCity regionCity : cityIdList) {
                cityIds.add(regionCity.getCityId());
            }
            cityList = chinaMapper.selectList(new QueryWrapper<China>().in("id", cityIds));
            redisCache.setCacheList("region_id:" + regionId, cityList);
        }
        return cityList;
    }

    @Override
    public List<China> getDistrictsByCityId(Long cityId) {
        List<China> districtList = redisCache.getCacheList("city_id:" + cityId);
        if (ObjectUtils.isEmpty(districtList)) {
            districtList = chinaMapper.selectList(new QueryWrapper<China>().eq("pid", cityId));
            redisCache.setCacheList("province_id:" + cityId, districtList);
        }
        return districtList;
    }
}
