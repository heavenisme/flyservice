package com.heaven.fly.core.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.heaven.fly.core.api.ApiCode;
import com.heaven.fly.core.api.ApiConst;
import com.heaven.fly.core.api.ApiResult;
import com.heaven.fly.core.api.ServiceException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: heaven
 * @Date: 2018/7/4 15:12
 * @Description:
 */
@ControllerAdvice
public class GlobalExceptionResolver {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    @ExceptionHandler(UnauthenticatedException.class)
    public void page401(HttpServletResponse response, UnauthenticatedException e) {
        ApiResult<Object> result = new ApiResult<>();
        result.setCode(ApiCode.UNAUTHEN).setMsg(ApiConst.UNLOGIN).setData(null);
        responseResult(response, result);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public void page403(HttpServletResponse response) {
        ApiResult<Object> result = new ApiResult<>();
        result.setCode(ApiCode.UNAUTHZ).setMsg(ApiConst.UNAUTHZ).setData(null);
        responseResult(response, result);
    }
    /**
     * 业务异常的处理
     */
    @ExceptionHandler(value = ServiceException.class)
    public void serviceExceptionHandler(HttpServletResponse response, ServiceException e) {
        ApiResult<Object> result = new ApiResult<>();
        result.setCode(ApiCode.FAIL).setMsg(e.getMessage()).setData(null);
        responseResult(response, result);
    }
    /**
     * 其他异常统一处理
     */
    @ExceptionHandler(value = Exception.class)
    public void exceptionHandler(HttpServletResponse response, Exception e) {
        ApiResult<Object> result = new ApiResult<>();
        result.setCode(ApiCode.INTERNAL_SERVER_ERROR).setMsg(ApiConst.SERVERERR);
        logger.error(e.getMessage(), e);
        responseResult(response, result);
    }
    /**
     * @param response
     * @param result
     * @Title: responseResult
     * @Description: 响应结果
     * @Reutrn void
     */
    private void responseResult(HttpServletResponse response, ApiResult<Object> result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }
}
