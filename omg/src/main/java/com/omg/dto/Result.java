package com.omg.dto;

public class Result {
    private Integer code;
    private String msg;
    private Object detail;

    public Result(Integer code, String msg, Object detail) {
        this.code = code;
        this.msg = msg;
        this.detail = detail;
    }

    public static Result successResult() {
        return new Result(200, "OK", null);
    }

    public static Result successResult(Object d) {
        return new Result(200, "OK", d);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getDetail() {
        return detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }
}
