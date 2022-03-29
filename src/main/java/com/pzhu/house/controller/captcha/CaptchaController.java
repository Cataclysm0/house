package com.pzhu.house.controller.captcha;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.util.IdUtil;
import com.pzhu.house.common.constant.Constants;
import com.pzhu.house.model.support.AjaxResult;
import com.pzhu.house.utils.redis.RedisCache;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Api(tags = "验证码控制器")
@RestController
public class CaptchaController {

    @Autowired
    private RedisCache redisCache;

    @ApiOperation("获取验证码图片")
    @GetMapping("/captchaImage")
    public AjaxResult captcha() {
        AjaxResult result = new AjaxResult();
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(80, 40, 4, 100);
        // 生成code
        lineCaptcha.createCode();
        String uuid = IdUtil.simpleUUID();
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;
        redisCache.setCacheObject(verifyKey, lineCaptcha.getCode(), Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        result.put("uuid", uuid);
        result.put("img", lineCaptcha.getImageBase64());
        return result;
    }

}
