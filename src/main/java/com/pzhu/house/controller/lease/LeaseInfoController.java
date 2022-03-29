package com.pzhu.house.controller.lease;

import com.google.common.collect.ImmutableMap;
import com.pzhu.house.model.dto.lease.LandlordInfoDTO;
import com.pzhu.house.model.dto.lease.LeaseInfoDTO;
import com.pzhu.house.model.entity.lease.LeaseInfo;
import com.pzhu.house.model.entity.system.SysUser;
import com.pzhu.house.model.support.AjaxResult;
import com.pzhu.house.service.lease.ILeaseInfoService;
import com.pzhu.house.service.system.ISysUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 租约信息表 前端控制器
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
@RestController
@RequestMapping("/lease-info")
public class LeaseInfoController {

    @Autowired
    private ILeaseInfoService leaseInfoService;

    @Autowired
    private ISysUserService userService;

    @ApiOperation("获取租约详情")
    @GetMapping("/getDetails")
    public AjaxResult leaseDetails(Long leaseId) {
        AjaxResult result = AjaxResult.success();
        LeaseInfo leaseInfo = leaseInfoService.getLeaseDetails(leaseId);
        SysUser landlordInfo = userService.getLandlordInfo(leaseInfo.getLandlordId());
        LeaseInfoDTO leaseInfoDTO = new LeaseInfoDTO().convertFrom(leaseInfo);
        LandlordInfoDTO landlordInfoDTO = new LandlordInfoDTO().convertFrom(landlordInfo);
        result.put("leaseInfo", leaseInfoDTO);
        result.put("landlordInfo", landlordInfoDTO);
        return result;
    }

}
