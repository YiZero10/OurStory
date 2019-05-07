package com.yiling.ourstory.model;

public enum ListStatus {
    DELETE(0,"删除"),

    COMPLETE(1,"已完成"),

    UNCOMPLETED(2,"未完成"),

    ;

    private int code;
    private String type;

    ListStatus(int code, String type) {
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
