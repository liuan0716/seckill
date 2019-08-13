package com.example.dto;

import com.example.bean.StatusEnum;

import java.util.Objects;

public class SeckillResult<T> {

    private boolean status;
    private String message;
    private T object;

    public SeckillResult() {
    }

    public SeckillResult(boolean status,String message, T object) {
        this.status = status;
        this.object = object;
        this.message=message;
    }

    public SeckillResult(boolean status, T object) {
        this.status = status;
        this.object = object;
    }

    public SeckillResult(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
