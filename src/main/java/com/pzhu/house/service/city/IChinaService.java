package com.pzhu.house.service.city;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pzhu.house.model.entity.city.China;

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
    List<China> getProvinceList();
}
