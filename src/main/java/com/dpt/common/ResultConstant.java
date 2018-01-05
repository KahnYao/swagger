package com.dpt.common;

public enum ResultConstant {

    SUCCESS(0, "操作成功。"),

    ERROR(1, "系统错误，请联系管理员。"),

    FILE_TYPE_ERROR(1001, "文件类型不支持。"),

    INVALID_LENGTH(1002, "无效长度。"),

    INVALID_PARAMETER(1003, "无效参数。");

    public int code;

    public String message;

    ResultConstant(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
