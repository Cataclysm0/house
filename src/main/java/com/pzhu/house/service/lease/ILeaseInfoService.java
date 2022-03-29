package com.pzhu.house.service.lease;

import com.pzhu.house.model.entity.lease.LeaseInfo;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
