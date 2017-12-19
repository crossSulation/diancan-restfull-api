package com.diancan.web.resto.error;


public class GlobalException extends RuntimeException {

    private String customMessage ;

    public GlobalException() {
    }

    public GlobalException(String message) {
        super(message);
        this.customMessage =message;
    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);
        this.customMessage =message;
    }

    @Override
    public String getMessage() {
        return customMessage;
    }

    public void setMessage(String message) {
        this.customMessage = message;
    }
}
