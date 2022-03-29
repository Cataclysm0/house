package com.pzhu.house.exception;

import cn.dev33.satoken.exception.NotLoginException;
import com.pzhu.house.exception.captcha.CaptchaException;
import com.pzhu.house.exception.captcha.CaptchaExpireException;
import com.pzhu.house.exception.captcha.CaptchaIncorrectException;
import com.pzhu.house.model.support.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public AjaxResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException) {
        log.error(methodArgumentNotValidException.getMessage());
        ArrayList<String> errorList = new ArrayList<>();
        for (ObjectError allError : methodArgumentNotValidException.getBindingResult().getAllErrors()) {
            errorList.add(allError.getDefaultMessage());
        }
        return AjaxResult.error(400, errorList.toString());
    }

    @ExceptionHandler(CaptchaException.class)
    public AjaxResult CaptchaExceptionHandler(CaptchaException captchaException) {
        String message;
        if (captchaException instanceof CaptchaIncorrectException) {
            message = "验证码错误";
        } else if (captchaException instanceof CaptchaExpireException) {
            message = "验证码过期";
        } else {
            message = "验证码渲染失败";
        }
        log.error(message);
        return AjaxResult.error(402, message);
    }

    // 全局异常拦截（拦截项目中的NotLoginException异常）
    @ExceptionHandler(NotLoginException.class)
    public AjaxResult notLoginExceptionHandler(NotLoginException nle, HttpServletRequest request, HttpServletResponse response) {
        // 判断场景值，定制化异常信息
        String message = "";
        if (nle.getType().equals(NotLoginException.NOT_TOKEN)) {
            message = "未提供token";
        } else if (nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "token无效";
        } else if (nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            message = "token已过期";
        } else if (nle.getType().equals(NotLoginException.BE_REPLACED)) {
            message = "token已被顶下线";
        } else if (nle.getType().equals(NotLoginException.KICK_OUT)) {
            message = "token已被踢下线";
        } else {
            message = "当前会话未登录";
        }
        log.error(nle.getMessage());
        // 返回给前端
        return AjaxResult.error(401, message);
    }

    @ExceptionHandler(BaseException.class)
    public AjaxResult baseExceptionHandler(BaseException baseException) {
        log.error(baseException.getMessage());
        return AjaxResult.error(baseException.getCode() == null ? 500 : baseException.getCode(), baseException.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public AjaxResult exceptionHandler(Exception e) {
        log.error(e.getMessage());
        return AjaxResult.error(e.getMessage());
    }

}
