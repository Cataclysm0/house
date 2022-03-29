package com.pzhu.house.service.lease.impl;

import com.pzhu.house.model.entity.lease.HouseInfo;
import com.pzhu.house.mapper.lease.HouseInfoMapper;
import com.pzhu.house.service.lease.IHouseInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 房源信息表 服务实现类
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
@Service
public class HouseInfoServiceImpl extends ServiceImpl<HouseInfoMapper, HouseInfo> implements IHouseInfoService {

}
