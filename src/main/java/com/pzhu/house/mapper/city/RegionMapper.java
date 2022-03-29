package com.pzhu.house.mapper.city;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pzhu.house.model.entity.city.Region;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 大区表 Mapper 接口
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
@Mapper
public interface RegionMapper extends BaseMapper<Region> {

}
