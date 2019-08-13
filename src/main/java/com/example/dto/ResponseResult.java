package com.example.dto;

import java.io.Serializable;
import java.util.Objects;

public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = -6926489986906745685L;
    private int status;
    private String mess;
    private T object;

    public ResponseResult(int status, String mess, T object) {
        this.status = status;
        this.mess = mess;
        this.object = object;
    }

    public ResponseResult(int status, String mess) {
        this.status = status;
        this.mess = mess;
    }

    public ResponseResult(int status, T object) {
        this.status = status;
        this.object = object;
    }

    public ResponseResult() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseResult<?> that = (ResponseResult<?>) o;
        return status == that.status &&
                Objects.equals(mess, that.mess) &&
                Objects.equals(object, that.object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, mess, object);
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "status=" + status +
                ", mess='" + mess + '\'' +
                ", object=" + object +
                '}';
    }
}
