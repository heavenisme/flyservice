package com.heaven.fly.controller;

import com.heaven.fly.core.api.ApiResult;
import com.heaven.fly.core.api.ApiResponse;
import com.heaven.fly.core.utils.GlobalUtils;
import com.heaven.fly.model.SysPermissionInit;
import com.heaven.fly.service.SysPermissionInitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: SysPermissionInitController类
* @author heaven
* @date 2018/07/02 17:28
*/
@RestController
@RequestMapping("/sysPermissionInit")
public class SysPermissionInitController {

    @Resource
    private SysPermissionInitService sysPermissionInitService;

    @PostMapping("/insert")
    public ApiResult<Integer> insert(SysPermissionInit sysPermissionInit) throws Exception{
        sysPermissionInit.setId(GlobalUtils.getUUID());
        Integer state = sysPermissionInitService.insert(sysPermissionInit);
        return ApiResponse.makeOKRsp(state);
    }


    @PostMapping("/deleteById")
    public ApiResult<Integer> deleteById(@RequestParam String id) throws Exception {
            Integer state = sysPermissionInitService.deleteById(id);
            return ApiResponse.makeOKRsp(state);
    }

    @PostMapping("/update")
    public ApiResult<Integer> update(SysPermissionInit sysPermissionInit) throws Exception {
            Integer state = sysPermissionInitService.update(sysPermissionInit);
            return ApiResponse.makeOKRsp(state);
    }

    @PostMapping("/selectById")
    public ApiResult<SysPermissionInit> selectById(@RequestParam String id) throws Exception {
            SysPermissionInit sysPermissionInit = sysPermissionInitService.selectById(id);
             return ApiResponse.makeOKRsp(sysPermissionInit);
    }
    /**
    * @Description: 分页查询
    * @param page 页码
    * @param size 每页条数
    * @Reutrn ApiResult<PageInfo<SysPermissionInit>>
    */
    @PostMapping("/list")
    public ApiResult<PageInfo<SysPermissionInit>> list(@RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<SysPermissionInit> list = sysPermissionInitService.selectAll();
        PageInfo<SysPermissionInit> pageInfo = new PageInfo<SysPermissionInit>(list);
        return ApiResponse.makeOKRsp(pageInfo);
    }
 }
