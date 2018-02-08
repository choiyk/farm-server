package com.todayfarmer.domain;

public class APIResult {

	boolean success;
    String message;
    Object data;

    public APIResult(boolean success) {
        this.success = success;
    }
    public APIResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public APIResult(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
