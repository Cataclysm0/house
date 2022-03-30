package com.pzhu.house.service.house.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pzhu.house.entity.house.HousePicture;
import com.pzhu.house.mapper.house.HousePictureMapper;
import com.pzhu.house.service.house.IHousePictureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 房源图片表 服务实现类
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-29
 */
@Service
public class HousePictureServiceImpl extends ServiceImpl<HousePictureMapper, HousePicture> implements IHousePictureService {

    @Autowired
    private HousePictureMapper housePictureMapper;

    @Override
    public String getCoverByHouseId(Long houseId) {

        return housePictureMapper.selectOne(new QueryWrapper<HousePicture>().eq("house_id", houseId).orderByAsc("order_num").last("LIMIT 1")).getImgUrl();
    }
}
