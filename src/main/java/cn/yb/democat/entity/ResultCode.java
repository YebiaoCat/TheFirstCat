package cn.yb.democat.entity;

import lombok.Data;


public enum ResultCode  {

    /* 成功状态码 */
    SUCCESS(200, "成功"),

    /* 系统500错误*/
    SYSTEM_ERROR(99999, "系统异常，请稍后重试"),

    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_NULL(10002, "参数为空"),
    /* 用户错误：20001-29999*/
    USER_HAS_EXISTED(20001, "用户名已存在"),
    USER_NOT_FIND(20002, "用户名不存在"),
    USER_PASSWORD_ERROR(20003,"密码错误");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

}

