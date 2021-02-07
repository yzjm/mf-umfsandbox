package com.mf.controller;

import com.mf.common.CommonResponse;
import com.mf.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;


@ControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    private LogService logService;

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResponse handleException(@NotNull Exception e) {
        String msg = e.getMessage() + (e.getCause() == null ? "" : "[" + e.getCause().getMessage() + "]");
        logService.printLog("出现异常：" + msg);
        return new CommonResponse("9999", msg, null);
    }
}
