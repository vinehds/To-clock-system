package com.vinehds.ToClockSystem.entities.enums;

public enum Gender {
    MALE(0),
    FEMALE(1);

    private int code;

    private Gender(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static Gender valueOf(int code){
        for (Gender value : Gender.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid gender code!");
    }
}
