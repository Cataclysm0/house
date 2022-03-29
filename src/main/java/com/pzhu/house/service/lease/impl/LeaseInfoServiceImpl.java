package com.pzhu.house.service.lease.impl;

import com.pzhu.house.mapper.lease.LeaseInfoMapper;
import com.pzhu.house.model.entity.lease.LeaseInfo;
import com.pzhu.house.service.lease.ILeaseInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 获取租约详情
     * @param leaseId
     * @return
     */
    @Override
    public LeaseInfo getLeaseDetails(Long leaseId) {
        return leaseInfoMapper.selectLeaseDetails(leaseId);
    }
}
