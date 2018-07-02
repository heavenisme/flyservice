package com.heaven.fly.controller;

import com.heaven.fly.core.api.ApiResponse;
import com.heaven.fly.core.api.ApiResult;
import com.heaven.fly.service.RedisService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: heaven
 * @Date: 2018/6/23 11:57
 * @Description:
 */
@RestController
@RequestMapping("redis")
public class RedisController {
    @Resource
    private RedisService redisService;

    @ApiOperation(value = "redis_value", notes = "设置redis value")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "string", required = true,
                    dataType = "String", paramType = "query")
    })
    @PostMapping("/setRedis")
    public ApiResult<String> setRedis(String name) {
        redisService.set("name",name);
        return ApiResponse.makeOKRsp(name);
    }

    @PostMapping("/getRedis")
    public ApiResult<String> getRedis() {
        String name = redisService.get("name");
        return ApiResponse.makeOKRsp(name);
    }


}
