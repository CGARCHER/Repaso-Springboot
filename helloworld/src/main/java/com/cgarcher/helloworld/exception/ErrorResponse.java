package com.cgarcher.helloworld.exception;

public class ErrorResponse {

    private String message;
    private Integer errorcode;
    private String details;

    public ErrorResponse(String message, Integer errorcode, String details) {
        this.message = message;
        this.errorcode = errorcode;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(Integer errorcode) {
        this.errorcode = errorcode;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
