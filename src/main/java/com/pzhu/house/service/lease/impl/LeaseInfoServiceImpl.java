package com.pzhu.house.service.lease.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pzhu.house.entity.house.HouseInfo;
import com.pzhu.house.mapper.lease.LeaseInfoMapper;
import com.pzhu.house.model.lease.BriefLeaseInfo;
import com.pzhu.house.entity.lease.LeaseInfo;
import com.pzhu.house.service.house.IHouseInfoService;
import com.pzhu.house.service.house.IHousePictureService;
import com.pzhu.house.service.lease.ILeaseInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 租约信息表 服务实现类
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
@Service
public class LeaseInfoServiceImpl extends ServiceImpl<LeaseInfoMapper, LeaseInfo> implements ILeaseInfoService {

    @Autowired
    private LeaseInfoMapper leaseInfoMapper;

    @Autowired
    private IHouseInfoService houseInfoService;

    @Autowired
    private IHousePictureService housePictureService;

    /**
     * 获取租约详情
     * @param leaseId
     * @return
     */
    @Override
    public LeaseInfo getLeaseDetails(Long leaseId) {
        return leaseInfoMapper.selectLeaseDetails(leaseId);
    }

    @Override
    public List<BriefLeaseInfo> getSummaryLeaseInfoList(Long loginId) {
        ArrayList<BriefLeaseInfo> list = new ArrayList<>();
        List<LeaseInfo> leaseInfos = leaseInfoMapper.selectList(new QueryWrapper<LeaseInfo>().eq("tenantId", loginId));
        for (LeaseInfo leaseInfo : leaseInfos) {
            BriefLeaseInfo briefLeaseInfo = new BriefLeaseInfo();
            String cover_url = housePictureService.getCoverByHouseId(leaseInfo.getHouseId());
            HouseInfo houseInfo = houseInfoService.getHouseInfo(leaseInfo.getHouseId());
            briefLeaseInfo.setId(leaseInfo.getId());
            briefLeaseInfo.setCover(cover_url);
            briefLeaseInfo.setAddress(houseInfo.getAddress());
            briefLeaseInfo.setDistrict(houseInfo.getDistrict());
            briefLeaseInfo.setStatus(leaseInfo.getStatus());
            briefLeaseInfo.setRent(leaseInfo.getRent());
            briefLeaseInfo.setTitle(houseInfo.getTitle());
        }
        return list;
    }
}
