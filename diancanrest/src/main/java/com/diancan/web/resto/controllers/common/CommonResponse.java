package com.diancan.web.resto.controllers.common;

public class CommonResponse {

    private int status;

    private String message;

    public CommonResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public CommonResponse() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
