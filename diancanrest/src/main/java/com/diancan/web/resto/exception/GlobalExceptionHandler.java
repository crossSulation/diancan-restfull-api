package com.diancan.web.resto.exception;

import com.diancan.web.resto.error.GlobalException;
import com.diancan.web.resto.error.ResponseErroMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.ServletRequest;

@RestControllerAdvice(basePackages = "com.diancan.web.resto.controllers")
public class GlobalExceptionHandler {

    @ExceptionHandler(value = GlobalException.class)
    @ResponseBody
    public ResponseEntity<?> defaultHandle(ServletRequest request, Throwable ex) {
        HttpStatus status = getHttpStatus(request);
        return  new ResponseEntity<ResponseErroMsg>(new ResponseErroMsg(status.value(),ex.getLocalizedMessage(),request.getLocalAddr(),status),status);
    }

    private HttpStatus getHttpStatus(ServletRequest request) {
        Integer statusCode =(Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode!=null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return  HttpStatus.valueOf(statusCode);
    }
}
