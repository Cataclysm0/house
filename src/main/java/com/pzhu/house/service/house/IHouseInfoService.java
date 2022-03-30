package com.pzhu.house.service.house;

import com.pzhu.house.entity.house.HouseInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pzhu.house.model.house.BriefHouseInfo;
import com.pzhu.house.model.params.mobile.IndexHoseListParams;

import java.util.List;

/**
 * <p>
 * 房源信息表 服务类
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
public interface IHouseInfoService extends IService<HouseInfo> {

    HouseInfo getHouseInfo(Long houseId);

    List<BriefHouseInfo> getIndexHouseInfoList(IndexHoseListParams params);
}
