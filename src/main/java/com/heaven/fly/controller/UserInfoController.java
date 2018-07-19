package com.heaven.fly.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heaven.fly.core.aop.AnnotationLog;
import com.heaven.fly.core.api.ApiResponse;
import com.heaven.fly.core.api.ApiResult;
import com.heaven.fly.core.api.ServiceException;
import com.heaven.fly.core.common.model.PageRequestInfo;
import com.heaven.fly.core.utils.GlobalUtils;
import com.heaven.fly.model.UserInfo;
import com.heaven.fly.model.reqmodel.Login;
import com.heaven.fly.model.reqmodel.RegistInfo;
import com.heaven.fly.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;


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

    @ApiOperation(value = "用户注册", notes = "用户注册")
    @PostMapping("/register")
//    @RequiresPermissions("userInfo:view")//权限管理;
    public ApiResult<UserInfo> register(@RequestBody RegistInfo registInfo) {
        if(StringUtils.isEmpty(registInfo.userAccount)) {
            return ApiResponse.makeRsp(-1,"用户名不能为空");
        } else if(StringUtils.isEmpty(registInfo.password)) {
            return ApiResponse.makeRsp(-1,"密码不能为空");
        }

       UserInfo exitUser = userInfoService.selectBy("phone",registInfo.userAccount);

        if(exitUser != null) {
            return ApiResponse.makeRsp(-1,"用户名已被注册");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(GlobalUtils.randomUUID());
        userInfo.setPhone(registInfo.userAccount);
        userInfo.setSalt(userInfo.getUserId().substring(0,5));
        userInfo.setPassword(GlobalUtils.getShiroPassword(registInfo.password,userInfo.getSalt()));
        userInfoService.insert(userInfo);
        return ApiResponse.makeOKRsp(userInfo);
    }

    @ApiOperation(value = "用户登录", notes = "用户登录")
    @PostMapping("/login")
//    @RequiresPermissions("userInfo:add")//权限管理;
    public ApiResult<UserInfo> login(@RequestBody Login login) {
        Subject currentUser = SecurityUtils.getSubject();
        //登录
        try {
            currentUser.login(new UsernamePasswordToken(login.userName, login.password));
        } catch (IncorrectCredentialsException i) {
            throw new ServiceException("密码输入错误");
        }
        //从session取出用户信息
        UserInfo user = (UserInfo) currentUser.getPrincipal();
        return ApiResponse.makeOKRsp(user);
    }


    @ApiOperation(value = "查询用户", notes = "根据用户ID查询用户")
    @PostMapping("/selectById")
    @AnnotationLog(remark = "查询")
    @RequiresPermissions("userInfo:del")//权限管理;
    public ApiResult<UserInfo> selectById(String id) {
        UserInfo userInfo = userInfoService.selectById(id);
        return ApiResponse.makeOKRsp(userInfo);
    }

    @ApiOperation(value = "查询用户", notes = "查询用户所有")
    @PostMapping("/selectAll")
    @RequiresPermissions("userInfo:del")//权限管理;
    public ApiResult<List<UserInfo>> selectAll() {
        List<UserInfo> userInfoList = userInfoService.selectAll();
        return ApiResponse.makeOKRsp(userInfoList);
    }

    @ApiOperation(value = "查询用户", notes = "分页查询用户所有")
    @PostMapping("/selectByPage")
    public ApiResult<PageInfo<UserInfo>> selectByPage(@RequestBody PageRequestInfo pageRequestInfo) {
        PageHelper.startPage(pageRequestInfo.page, pageRequestInfo.pageSize);
        List<UserInfo> userInfoList = userInfoService.selectAll();
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfoList);
        return ApiResponse.makeOKRsp(pageInfo);
    }
}
