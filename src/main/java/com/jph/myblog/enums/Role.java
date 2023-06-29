package com.jph.myblog.enums;


public enum Role {

    ADMIN(0),
    ORDINARY_USER(1);

    private final Integer code;

    Role(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
