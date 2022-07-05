package com.daryl.domain;

/**
 * @author wl
 * @date 2022-06-28
 */
public class ResponseResult<T> {
    private Integer code;

    private String msg;

    private T data;

    public ResponseResult(T data) {
        this.code = 666;
        this.msg = "真的C";
        this.data = data;
    }

    public ResponseResult() {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
