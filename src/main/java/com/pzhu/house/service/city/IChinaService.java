package com.pzhu.house.service.city;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pzhu.house.entity.city.China;

import java.util.List;

/**
 * <p>
 * 中国城市表 服务类
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
public interface IChinaService extends IService<China> {

    /**
     * 省份列表
     * @return
     */
    List<China> getAllProvinceList();

    /**
     * 城市列表
     * @param provinceId
     * @return
     */
    List<China> getCityListByProvinceId(Long provinceId);

    List<China> getCityListByRegionId(Long regionId);

    List<China> getDistrictsByCityId(Long cityId);
}
