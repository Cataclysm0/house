package com.pzhu.house.controller.lease;

import cn.dev33.satoken.stp.StpUtil;
import com.pzhu.house.model.dto.lease.HouseInfoDTO;
import com.pzhu.house.model.dto.lease.LandlordInfoDTO;
import com.pzhu.house.model.dto.lease.LeaseInfoDTO;
import com.pzhu.house.model.lease.BriefLeaseInfo;
import com.pzhu.house.entity.house.HouseInfo;
import com.pzhu.house.entity.lease.LeaseInfo;
import com.pzhu.house.entity.system.SysUser;
import com.pzhu.house.model.support.AjaxResult;
import com.pzhu.house.service.house.IHouseInfoService;
import com.pzhu.house.service.lease.ILeaseInfoService;
import com.pzhu.house.service.system.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 租约信息表 前端控制器
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-27
 */
@Api(tags = "租约信息控制器")
@RestController
@RequestMapping("/user/lease-info")
public class LeaseInfoController {

    @Autowired
    private ILeaseInfoService leaseInfoService;

    @Autowired
    private ISysUserService userService;
    @Autowired
    private IHouseInfoService houseInfoService;

    @ApiOperation("获取当前用户所有租约信息")
    @GetMapping("/get-summary-lease-info")
    public AjaxResult getSummaryLeaseInfo() {
        AjaxResult result = AjaxResult.success();
        Long loginId = (Long) StpUtil.getLoginId();
        List<BriefLeaseInfo> leaseInfos = leaseInfoService.getSummaryLeaseInfoList(loginId);
        result.put("leaseInfos", leaseInfos);
        return result;
    }

    @ApiOperation("获取租约详情")
    @GetMapping("/get-details")
    public AjaxResult leaseDetails(Long leaseId) {
        AjaxResult result = AjaxResult.success();
        LeaseInfo leaseInfo = leaseInfoService.getLeaseDetails(leaseId);
        SysUser landlordInfo = userService.getLandlordInfo(leaseInfo.getLandlordId());
        HouseInfo houseInfo = houseInfoService.getHouseInfo(leaseInfo.getHouseId());
        LeaseInfoDTO leaseInfoDTO = new LeaseInfoDTO().convertFrom(leaseInfo);
        LandlordInfoDTO landlordInfoDTO = new LandlordInfoDTO().convertFrom(landlordInfo);
        HouseInfoDTO houseInfoDTO = new HouseInfoDTO().convertFrom(houseInfo);
        result.put("leaseInfo", leaseInfoDTO);
        result.put("landlordInfo", landlordInfoDTO);
        result.put("houseInfo", houseInfoDTO);
        return result;
    }

}
