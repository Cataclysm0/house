package com.pzhu.house.service.house.impl;

import cn.hutool.core.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pzhu.house.entity.house.HouseInfo;
import com.pzhu.house.mapper.house.HouseInfoMapper;
import com.pzhu.house.model.house.BriefHouseInfo;
import com.pzhu.house.model.params.mobile.IndexHoseListParams;
import com.pzhu.house.service.house.IHouseInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pzhu.house.service.house.IHousePictureService;
import com.pzhu.house.service.house.ITagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private HouseInfoMapper houseInfoMapper;

    @Autowired
    private IHousePictureService housePictureService;

    @Autowired
    private ITagsService tagsService;

    @Override
    public HouseInfo getHouseInfo(Long houseId) {
        return houseInfoMapper.selectOne(new QueryWrapper<HouseInfo>().eq("id", houseId));
    }

    @Override
    public List<BriefHouseInfo> getIndexHouseInfoList(IndexHoseListParams params) {
        int[] startEnd = PageUtil.transToStartEnd(params.getPage() == null ? 0 : params.getPage()-1, 20);
        List<HouseInfo> houseInfos = houseInfoMapper.selectList(new QueryWrapper<HouseInfo>().like("city", params.getCityName()).like(!ObjectUtils.isEmpty(params.getDistrict()), "district", params.getDistrict()).eq("status", 0).last("LIMIT "+startEnd[0]+","+startEnd[1]));
        ArrayList<BriefHouseInfo> list = new ArrayList<>();
        for (HouseInfo houseInfo : houseInfos) {
            BriefHouseInfo info = new BriefHouseInfo();
            info.setTitle(houseInfo.getTitle());
            info.setArea(houseInfo.getArea());
            info.setCompoundName(houseInfo.getCompoundName());
            info.setCover(housePictureService.getCoverByHouseId(houseInfo.getId()));
            info.setDistrict(houseInfo.getDistrict());
            info.setId(houseInfo.getId());
            info.setPrice(houseInfo.getPrice());
            info.setTags(tagsService.getTagList(houseInfo.getId()));
            list.add(info);
        }
        return list;
    }
}
