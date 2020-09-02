package com.ybs.common.response;

import com.ybs.common.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Result
 * 统一返回结果集
 *
 * @author Paulson
 * @date 2020/3/25 23:19
 */


@Data
@Builder
@AllArgsConstructor
public class Result<T> implements Serializable {
    private Boolean success;
    private Integer code;
    private String msg;
    private T data;

    public Result() {
        this.success = true;
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = ResultEnum.SUCCESS.getMsg();
    }

    public Result(Integer code) {
        this.success = true;
        this.code = code;
        this.msg = ResultEnum.SUCCESS.getMsg();
    }

    public Result(String msg) {
        this.success = true;
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = msg;
    }

    public Result(Integer code, String msg) {
        this.success = true;
        this.code = code;
        this.msg = msg;
    }

    public Result(T data) {
        this.success = true;
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = ResultEnum.SUCCESS.getMsg();
        this.data = data;
    }

    public Result(String msg, T data) {
        this.success = true;
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = msg;
        this.data = data;
    }

    public Result(ResultEnum resultEnum) {
        this.success = true;
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public Result(Integer code, String msg, T data) {
        this.success = true;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(boolean success, Integer code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public static Result success() {
        return new Result();
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(data);
    }

    public static Result success(String message) {
        return new Result(message);
    }

    public static Result fail() {
        return new Result(false, ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMsg());
    }

    public static Result fail(String message) {
        return new Result(false, ResultEnum.ERROR.getCode(), message);
    }

    public static Result fail(Integer code, String msg) {
        return new Result(false, code, msg);
    }

    public static Result fail(ResultEnum resultEnum) {
        Result result = new Result(resultEnum);
        result.setSuccess(false);
        return result;
    }

    public static <T> Result<T> fail(T data) {
        Result result = new Result(ResultEnum.ERROR);
        result.setSuccess(false);
        result.setData(data);
        return result;
    }
}
