package com.diancan.web.resto.error;


import org.springframework.http.HttpStatus;

public class ResponseErroMsg {
    private Integer code;
    private String message;
    private String path;
    private HttpStatus httpStatus;

    public ResponseErroMsg(Integer code, String message, String path, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.path = path;
        this.httpStatus = httpStatus;
    }

    public ResponseErroMsg() {

    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
