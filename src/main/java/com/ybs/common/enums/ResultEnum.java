package com.ybs.common.enums;

import lombok.Getter;

/**
 * ResultEnum
 * 返回结果枚举
 *
 * @author Paulson
 * @date 2020/3/25 22:51
 */

@Getter
public enum ResultEnum {
    /**
     * 枚举
     */
    SUCCESS(200, "操作成功"),
    ERROR(400, "操作失败"),
    EXCEPTION(500, "服务异常"),
    PARAMS_ERROR(40000, "参数异常"),
    RESPONSE_NULL(40001, "无此数据"),
    ;

    /**
     * 返回结果枚举，每个枚举代表着一个返回状态
     */
    private final Integer code;
    private final String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
