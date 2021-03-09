package com.javakc.servicebase.handler;

import com.javakc.commonutils.api.APICODE;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局统一异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public APICODE errorHandler(Exception e){
        e.printStackTrace();
        return APICODE.ERROR().messages("Exception:服务器异常!");
    }

    @ExceptionHandler(HctfException.class)
    @ResponseBody
    public APICODE errorHandler(HctfException e){
        e.printStackTrace();
        return APICODE.ERROR().code(e.getCode()).messages(e.getMsg());
    }
}
