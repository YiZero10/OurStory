package com.yiling.ourstory.model;

public enum Category {

    TRAVEL(0,"游记"),

    WHISPER(1,"悄悄话"),

    MEMO(2,"备忘录"),

    LIFE(3,"日常")
    ;

    private int code;

    private String type;

    Category(int code, String type) {
        this.code = code;
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
