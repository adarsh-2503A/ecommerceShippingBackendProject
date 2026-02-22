package com.example.ecommerceShipping.exceptionHandling;

import java.time.LocalTime;

public class ShippingErrorResponse {

    private int statusCode;
    private String message;
    private String path;
    private LocalTime localTime = LocalTime.now();

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }
}