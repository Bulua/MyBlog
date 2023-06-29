package com.jph.myblog.utils;

import com.jph.myblog.entity.Result;

public class ResultUtil {

    public static Result success(String msg, Object obj) {
        return Result.builder().code(200).msg(msg).data(obj).build();
    }

    public static Result success(String msg) {
        return success(msg, null);
    }

    public static Result success() {
        return success(null, null);
    }

    public static Result error(Integer code, String msg, Object obj) {
        return Result.builder().code(code).msg(msg).data(obj).build();
    }

    public static Result error(Integer code, String msg) {
        return error(code, msg, null);
    }
}
