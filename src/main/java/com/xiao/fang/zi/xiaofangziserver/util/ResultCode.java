package com.xiao.fang.zi.xiaofangziserver.util;

public enum ResultCode {
    SUCCESS(0, "成功"),
    FAILED(1, "失败");


    private int code;
    private String message;

    private ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
