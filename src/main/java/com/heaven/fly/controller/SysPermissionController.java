package com.heaven.fly.controller;

import com.heaven.fly.core.api.ApiResult;
import com.heaven.fly.core.api.ApiResponse;
import com.heaven.fly.core.utils.GlobalUtils;
import com.heaven.fly.model.SysPermission;
import com.heaven.fly.service.SysPermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: SysPermissionController类
* @author heaven
* @date 2018/07/18 17:46
*/
@RestController
@RequestMapping("/sysPermission")
public class SysPermissionController {

    @Resource
    private SysPermissionService sysPermissionService;

    @PostMapping("/insert")
    public ApiResult<Integer> insert(SysPermission sysPermission) throws Exception{
        Integer state = sysPermissionService.insert(sysPermission);
        return ApiResponse.makeOKRsp(state);
    }


    @PostMapping("/deleteById")
    public ApiResult<Integer> deleteById(@RequestParam String id) throws Exception {
            Integer state = sysPermissionService.deleteById(id);
            return ApiResponse.makeOKRsp(state);
    }

    @PostMapping("/update")
    public ApiResult<Integer> update(SysPermission sysPermission) throws Exception {
            Integer state = sysPermissionService.update(sysPermission);
            return ApiResponse.makeOKRsp(state);
    }

    @PostMapping("/selectById")
    public ApiResult<SysPermission> selectById(@RequestParam String id) throws Exception {
            SysPermission sysPermission = sysPermissionService.selectById(id);
             return ApiResponse.makeOKRsp(sysPermission);
    }
    /**
    * @Description: 分页查询
    * @param page 页码
    * @param size 每页条数
    * @Reutrn ApiResult<PageInfo<SysPermission>>
    */
    @PostMapping("/list")
    public ApiResult<PageInfo<SysPermission>> list(@RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<SysPermission> list = sysPermissionService.selectAll();
        PageInfo<SysPermission> pageInfo = new PageInfo<SysPermission>(list);
        return ApiResponse.makeOKRsp(pageInfo);
    }
 }
