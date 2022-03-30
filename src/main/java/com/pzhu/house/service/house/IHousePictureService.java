package com.pzhu.house.service.house;

import com.pzhu.house.entity.house.HousePicture;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 房源图片表 服务类
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-29
 */
public interface IHousePictureService extends IService<HousePicture> {

    String getCoverByHouseId(Long houseId);
}
