package com.ybs.common.enums;

import lombok.Getter;

/**
 * StateEnums
 * 状态码枚举。所有的状态码
 * @author Paulson
 * @date 2020/3/25 23:00
 */

@Getter
public enum StateEnums {
    /**
     * 逻辑删除状态
     */
    DELETED(1, "已删除"),
    NOT_DELETED(0, "未删除"),

    /**
     * 启动状态
     */
    ENABLE(1, "已启动"),
    NOT_ENABLE(0, "未启动"),

    /**
     * 性别状态
     */
    SEX_MAN(1, "男"),
    SEX_WOMAN(2, "女"),
    ;
    private Integer code;
    private String message;

    StateEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
