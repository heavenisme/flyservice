package com.heaven.fly.controller;

import com.heaven.fly.core.api.ApiResult;
import com.heaven.fly.core.api.ApiResponse;
import com.heaven.fly.core.utils.GlobalUtils;
import com.heaven.fly.model.SystemLog;
import com.heaven.fly.service.SystemLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: SystemLogController类
* @author heaven
* @date 2018/06/23 10:42
*/
@RestController
@RequestMapping("/systemLog")
public class SystemLogController {

    @Resource
    private SystemLogService systemLogService;

    @PostMapping("/insert")
    public ApiResult<Integer> insert(SystemLog systemLog) throws Exception{
        systemLog.setId(GlobalUtils.getUUID());
        Integer state = systemLogService.insert(systemLog);
        return ApiResponse.makeOKRsp(state);
    }


    @PostMapping("/deleteById")
    public ApiResult<Integer> deleteById(@RequestParam String id) throws Exception {
            Integer state = systemLogService.deleteById(id);
            return ApiResponse.makeOKRsp(state);
    }

    @PostMapping("/update")
    public ApiResult<Integer> update(SystemLog systemLog) throws Exception {
            Integer state = systemLogService.update(systemLog);
            return ApiResponse.makeOKRsp(state);
    }

    @PostMapping("/selectById")
    public ApiResult<SystemLog> selectById(@RequestParam String id) throws Exception {
            SystemLog systemLog = systemLogService.selectById(id);
             return ApiResponse.makeOKRsp(systemLog);
    }
    /**
    * @Description: 分页查询
    * @param page 页码
    * @param size 每页条数
    * @Reutrn ApiResult<PageInfo<SystemLog>>
    */
    @PostMapping("/list")
    public ApiResult<PageInfo<SystemLog>> list(@RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<SystemLog> list = systemLogService.selectAll();
        PageInfo<SystemLog> pageInfo = new PageInfo<SystemLog>(list);
        return ApiResponse.makeOKRsp(pageInfo);
    }
 }
