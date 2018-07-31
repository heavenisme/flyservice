package com.heaven.fly.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heaven.fly.core.api.ApiResponse;
import com.heaven.fly.core.api.ApiResult;
import com.heaven.fly.model.sys.SysUrlPermission;
import com.heaven.fly.service.SysUrlPermissionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: SysUrlPermissionController类
* @author heaven
* @date 2018/07/30 09:38
*/
@RestController
@RequestMapping("/sysUrlPermission")
public class SysUrlPermissionController {

    @Resource
    private SysUrlPermissionService sysUrlPermissionService;

    @PostMapping("/insert")
    public ApiResult<Integer> insert(SysUrlPermission sysUrlPermission) throws Exception{
        Integer state = sysUrlPermissionService.insert(sysUrlPermission);
        return ApiResponse.makeOKRsp(state);
    }


    @PostMapping("/deleteById")
    public ApiResult<Integer> deleteById(@RequestParam String id) throws Exception {
            Integer state = sysUrlPermissionService.deleteById(id);
            return ApiResponse.makeOKRsp(state);
    }

    @PostMapping("/update")
    public ApiResult<Integer> update(SysUrlPermission sysUrlPermission) throws Exception {
            Integer state = sysUrlPermissionService.update(sysUrlPermission);
            return ApiResponse.makeOKRsp(state);
    }

    @PostMapping("/selectById")
    public ApiResult<SysUrlPermission> selectById(@RequestParam String id) throws Exception {
            SysUrlPermission sysUrlPermission = sysUrlPermissionService.selectById(id);
             return ApiResponse.makeOKRsp(sysUrlPermission);
    }
    /**
    * @Description: 分页查询
    * @param page 页码
    * @param size 每页条数
    * @Reutrn ApiResult<PageInfo<SysUrlPermission>>
    */
    @PostMapping("/list")
    public ApiResult<PageInfo<SysUrlPermission>> list(@RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<SysUrlPermission> list = sysUrlPermissionService.selectAll();
        PageInfo<SysUrlPermission> pageInfo = new PageInfo<>(list);
        return ApiResponse.makeOKRsp(pageInfo);
    }
 }
