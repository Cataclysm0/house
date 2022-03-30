package com.pzhu.house.mapper.lease;

import com.pzhu.house.entity.lease.LeaseInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 租约信息表 Mapper 接口
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
@Mapper
public interface LeaseInfoMapper extends BaseMapper<LeaseInfo> {

    /**
     * 获取租约详情
     * @param leaseId
     * @return
     */
    LeaseInfo selectLeaseDetails(Long leaseId);
}
