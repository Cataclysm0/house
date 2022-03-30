package com.pzhu.house.service.city;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pzhu.house.entity.city.Region;

import java.util.List;

/**
 * <p>
 * 大区表 服务类
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
public interface IRegionService extends IService<Region> {

    List<Region> getAllRegions();
}
