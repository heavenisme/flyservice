package com.heaven.fly.controller;

import com.github.pagehelper.PageInfo;
import com.heaven.fly.core.api.ApiResponse;
import com.heaven.fly.core.api.ApiResult;
import com.heaven.fly.model.UserInfo;
import com.heaven.fly.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;



/**
 * @Auther: heaven
 * @Date: 2018/6/19 17:51
 * @Description:
 */
@RestController
@RequestMapping("userInfo")
@Api(tags = {"用户操作接口"}, description = "userInfoControler")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/hello")
    public String hello(){
        return "hello SpringBoot";
    }

    @ApiOperation(value = "查询用户", notes = "根据用户ID查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true,
                    dataType = "Integer", paramType = "query")
    })
    @PostMapping("/selectById")
    public ApiResult<UserInfo> selectById(String id){
        UserInfo userInfo = userInfoService.selectById(id);
        return ApiResponse.makeOKRsp(userInfo);
    }

    @ApiOperation(value = "查询用户", notes = "分页查询用户所有")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码",
                    dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示条数",
                    dataType = "Integer", paramType = "query")
    })
    @PostMapping("/selectAll")
    public ApiResult<List<UserInfo>> selectAll(@RequestParam(defaultValue = "0") Integer page,
                                                   @RequestParam(defaultValue = "0") Integer size) {
        List<UserInfo> pageInfo = userInfoService.selectAll(page, size);
        return ApiResponse.makeOKRsp(pageInfo);
    }

    @PostMapping("/testException")
    public ApiResult<UserInfo> testException(Integer id){
        List a = null;
        a.size();
        UserInfo userInfo = userInfoService.selectById(id);
        return ApiResponse.makeOKRsp(userInfo);
    }

}
