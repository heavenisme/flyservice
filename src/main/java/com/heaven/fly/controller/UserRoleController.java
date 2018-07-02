package com.heaven.fly.controller;

import com.heaven.fly.core.api.ApiResult;
import com.heaven.fly.core.api.ApiResponse;
import com.heaven.fly.core.utils.GlobalUtils;
import com.heaven.fly.model.UserRole;
import com.heaven.fly.service.UserRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: UserRoleController类
* @author heaven
* @date 2018/07/02 16:37
*/
@RestController
@RequestMapping("/userRole")
public class UserRoleController {

    @Resource
    private UserRoleService userRoleService;

    @PostMapping("/insert")
    public ApiResult<Integer> insert(UserRole userRole) throws Exception{
        userRole.setId(GlobalUtils.getUUID());
        Integer state = userRoleService.insert(userRole);
        return ApiResponse.makeOKRsp(state);
    }


    @PostMapping("/deleteById")
    public ApiResult<Integer> deleteById(@RequestParam String id) throws Exception {
            Integer state = userRoleService.deleteById(id);
            return ApiResponse.makeOKRsp(state);
    }

    @PostMapping("/update")
    public ApiResult<Integer> update(UserRole userRole) throws Exception {
            Integer state = userRoleService.update(userRole);
            return ApiResponse.makeOKRsp(state);
    }

    @PostMapping("/selectById")
    public ApiResult<UserRole> selectById(@RequestParam String id) throws Exception {
            UserRole userRole = userRoleService.selectById(id);
             return ApiResponse.makeOKRsp(userRole);
    }
    /**
    * @Description: 分页查询
    * @param page 页码
    * @param size 每页条数
    * @Reutrn ApiResult<PageInfo<UserRole>>
    */
    @PostMapping("/list")
    public ApiResult<PageInfo<UserRole>> list(@RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<UserRole> list = userRoleService.selectAll();
        PageInfo<UserRole> pageInfo = new PageInfo<UserRole>(list);
        return ApiResponse.makeOKRsp(pageInfo);
    }
 }
