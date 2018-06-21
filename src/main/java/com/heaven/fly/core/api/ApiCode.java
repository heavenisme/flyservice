package com.heaven.fly.core.api;

/**
 * @Auther: heaven
 * @Date: 2018/6/20 21:25
 * @Description:
 */
public enum ApiCode {
    // 成功
    SUCCESS(200),

    // 失败
    FAIL(400),

    NOT_FOUND(404),

    // 未认证（签名错误）
    UNAUTHORIZED(401),

    /** 未登录 */
    UNAUTHEN(4401),

    /** 未授权，拒绝访问 */
    UNAUTHZ(4403),

    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500);

    public int code;

    ApiCode(int code) {
        this.code = code;
    }
}
