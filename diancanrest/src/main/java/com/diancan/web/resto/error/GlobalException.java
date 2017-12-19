package com.diancan.web.resto.error;

import com.diancan.web.resto.utils.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@RestControllerAdvice(basePackages = "com.diancan.web.resto.controllers")
public class GlobalException {

    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public  ResponseErroMsg defaultHandle(ServletRequest request, ServletResponse response,Exception e) {

        ResponseErroMsg erroMsg =new ResponseErroMsg();
        if(e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            erroMsg.setCode(404);
            erroMsg.setHttpStatus(HttpStatus.NOT_FOUND);
            erroMsg.setMessage(e.getLocalizedMessage());
        }else {
            erroMsg.setCode(500);
            erroMsg.setHttpStatus(HttpStatus.INNER_SERVER_ERROR);
            erroMsg.setMessage(e.getLocalizedMessage());
        }
        return  erroMsg;
    }
}
