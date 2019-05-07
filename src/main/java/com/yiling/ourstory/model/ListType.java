package com.yiling.ourstory.model;

public enum ListType {

    DAY(0,"每日小目标"),

    COMMON(1,"小目标")
    ;

    private int code;
    private String type;

    ListType(int code, String type) {
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
