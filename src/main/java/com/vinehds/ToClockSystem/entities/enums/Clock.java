package com.vinehds.ToClockSystem.entities.enums;

public enum Clock {
    IN(1),
    OUT(2);

    private int code;
    private Clock (int code){
        this.code = code;
    }

    public int getCode(){
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
