package com.diancan.web.resto.error;

import com.diancan.web.resto.utils.HttpStatus;

public class ResponseErroMsg extends   RuntimeException{
    private Integer code;
    private HttpStatus httpStatus;
    private String message;
    private String path;

    public ResponseErroMsg() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
