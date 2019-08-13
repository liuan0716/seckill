package com.example.bean;

public enum StatusEnum {

    OK(1,"success"),
    INNER_ERROR(-1,"inner fault"),
    SECKILL_ENDED(-2,"seckill overed"),
    SECKILL_REPEAT(-3,"seckill repeated"),
    USER_NOT_EXIST(-4,"user not exist");

    private int code;
    private String message;

    StatusEnum(int code, String message){
        this.code=code;
        this.message=message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static StatusEnum getValueOf(int code){

        for (StatusEnum status:StatusEnum.values()) {
            if(status.code==code){
                return status;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "StatusEnum{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
