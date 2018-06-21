package com.heaven.fly.core.api;

import java.io.Serializable;

/**
 * @Auther: heaven
 * @Date: 2018/6/20 22:24
 * @Description:
 */
public class ServiceException extends RuntimeException implements Serializable {
    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
