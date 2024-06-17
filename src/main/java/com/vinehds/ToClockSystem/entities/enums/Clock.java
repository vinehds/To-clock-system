package com.vinehds.ToClockSystem.entities.enums;

public enum Clock {
    IN(0),
    OUT(1);

    private int code;
    private Clock (int code){
        this.code = code;
    }

    public Integer getCode(){
        return code;
    }

    public static Clock valueOf(int code){
        for (Clock value : Clock.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid gender code!");
    }
}
