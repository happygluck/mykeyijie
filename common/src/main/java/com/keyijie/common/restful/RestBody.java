package com.keyijie.common.restful;

import java.io.Serializable;

/**
 * Restful实体
 */
public class RestBody<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    public RestBody(int code) {
        this.code = code;
    }

    public RestBody(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public RestBody(T data, int code) {
        this.data = data;
        this.code = code;
    }

    public RestBody(T data, int code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
