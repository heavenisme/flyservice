package com.heaven.fly.controller;

import com.heaven.fly.core.api.ApiResult;
import com.heaven.fly.core.api.ApiResponse;
import com.heaven.fly.core.utils.GlobalUtils;
import com.heaven.fly.model.UserInfo;
import com.heaven.fly.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: UserInfoController类
* @author heaven
* @date 2018/07/29 16:23
*/
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @PostMapping("/insert")
    public ApiResult<Integer> insert(UserInfo userInfo) throws Exception{
        Integer state = userInfoService.insert(userInfo);
        return ApiResponse.makeOKRsp(state);
    }


    @PostMapping("/deleteById")
    public ApiResult<Integer> deleteById(@RequestParam String id) throws Exception {
            Integer state = userInfoService.deleteById(id);
            return ApiResponse.makeOKRsp(state);
    }

    @PostMapping("/update")
    public ApiResult<Integer> update(UserInfo userInfo) throws Exception {
            Integer state = userInfoService.update(userInfo);
            return ApiResponse.makeOKRsp(state);
    }

    @PostMapping("/selectById")
    public ApiResult<UserInfo> selectById(@RequestParam String id) throws Exception {
            UserInfo userInfo = userInfoService.selectById(id);
             return ApiResponse.makeOKRsp(userInfo);
    }
    /**
    * @Description: 分页查询
    * @param page 页码
    * @param size 每页条数
    * @Reutrn ApiResult<PageInfo<UserInfo>>
    */
    @PostMapping("/list")
    public ApiResult<PageInfo<UserInfo>> list(@RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<UserInfo> list = userInfoService.selectAll();
        PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(list);
        return ApiResponse.makeOKRsp(pageInfo);
    }
 }
