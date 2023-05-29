package com.xiao.fang.zi.xiaofangziserver.util;

import java.io.Serializable;

public class CommonResult<T> implements Serializable {
    public static final long serialVersionUID = 54L;

    private int code;
    private String msg;
    private T data;

    private CommonResult() {
    }

    public CommonResult(T data) {
        super();
        this.data = data;
    }
    public CommonResult(int code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    public static <T> CommonResult<T> failed() {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(), null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

