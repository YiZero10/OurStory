package com.yiling.ourstory.model;

public enum ArticleStatus {
    DELETE(0,"删除"),

    COMMON(1,"普通"),

    TOP(2,"置顶"),

    ;

    private int code;
    private String type;

    ArticleStatus(int code, String type) {
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
