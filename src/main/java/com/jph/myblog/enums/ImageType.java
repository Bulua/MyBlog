package com.jph.myblog.enums;


public enum ImageType {

    // 封面图
    COVER_IMAGE(4),

    // 普通图
    NORMAL_IMAGE(1);

    private final Integer value;

    ImageType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
