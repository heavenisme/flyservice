package com.heaven.fly.core.api;

/**
 * @Auther: heaven
 * @Date: 2018/6/20 21:42
 * @Description:
 */
public class ApiResponse {

    public static <T> ApiResult<T> makeOKRsp() {
        return new ApiResult<T>().setCode(ApiCode.SUCCESS).setMsg(ApiConst.SUCCESS);
    }

    public static <T> ApiResult<T> makeOKRsp(T data) {
        return new ApiResult<T>().setCode(ApiCode.SUCCESS).setMsg(ApiConst.SUCCESS).setData(data);
    }

    public static <T> ApiResult<T> makeErrRsp(String message) {
        return new ApiResult<T>().setCode(ApiCode.FAIL).setMsg(ApiConst.SUCCESS);
    }

    public static <T> ApiResult<T> makeRsp(int code, String msg) {
        return new ApiResult<T>().setCode(code).setMsg(msg);
    }

    public static <T> ApiResult<T> makeRsp(int code, String msg, T data) {
        return new ApiResult<T>().setCode(code).setMsg(msg).setData(data);
    }
}
