package com.heaven.fly.core.api;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @Auther: heaven
 * @Date: 2018/6/20 21:37
 * @Description:
 */
public class ApiResult<T> implements Serializable {
    public int code;

    private String msg;

    private T data;

    public ApiResult<T> setCode(ApiCode apiCode) {
        this.code = apiCode.code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ApiResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ApiResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ApiResult<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
