package com.kin.springboot.webservices.springbootwebservices.exception;

import org.springframework.stereotype.Component;

import java.util.Date;


public class ErrorResponse {
    private Date timestamp;
    private String message;
    private String detail;

    public ErrorResponse(Date timestamp, String message, String detail) {
        this.timestamp = timestamp;
        this.message = message;
        this.detail = detail;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }

}