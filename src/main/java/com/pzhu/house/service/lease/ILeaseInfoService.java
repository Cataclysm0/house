package com.pzhu.house.service.lease;

import com.pzhu.house.model.lease.BriefLeaseInfo;
import com.pzhu.house.entity.lease.LeaseInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 租约信息表 服务类
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
public interface ILeaseInfoService extends IService<LeaseInfo> {

    /**
     * 获取租约详情
     * @param leaseId
     * @return
     */
    LeaseInfo getLeaseDetails(Long leaseId);

    List<BriefLeaseInfo> getSummaryLeaseInfoList(Long loginId);
}
