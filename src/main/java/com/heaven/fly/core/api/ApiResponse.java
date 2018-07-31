package com.heaven.fly.core.api;

import com.heaven.fly.core.language.LanguageMessage;

/**
 * @Auther: heaven
 * @Date: 2018/6/20 21:42
 * @Description:
 */
public class ApiResponse {

    public static <T> ApiResult<T> makeOKRsp() {
        return new ApiResult<T>().setCode(ApiCode.SUCCESS).setMsg(LanguageMessage.getMessage("login_success"));
    }

    public static <T> ApiResult<T> makeOKRsp(T data) {
        return new ApiResult<T>().setCode(ApiCode.SUCCESS).setMsg(LanguageMessage.getMessage("login_success")).setData(data);
    }

    public static <T> ApiResult<T> makeErrRsp(String msgTag) {
        return new ApiResult<T>().setCode(ApiCode.FAIL).setMsg(LanguageMessage.getMessage(msgTag));
    }

    public static <T> ApiResult<T> makeRsp(int code, String msg) {
        return new ApiResult<T>().setCode(code).setMsg(msg);
    }

    public static <T> ApiResult<T> makeRsp(int code, String msgTag, T data) {
        return new ApiResult<T>().setCode(code).setMsg(LanguageMessage.getMessage(msgTag)).setData(data);
    }
}
