package com.jph.myblog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    /* 状态码 */
    private Integer code;
    /* 提示信息 */
    private String msg;
    /* 返回内容 */
    private T data;

}
