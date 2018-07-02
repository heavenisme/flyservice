package com.heaven.fly.controller;

import com.heaven.fly.core.api.ApiResult;
import com.heaven.fly.core.api.ApiResponse;
import com.heaven.fly.core.utils.GlobalUtils;
import com.heaven.fly.model.RolePerm;
import com.heaven.fly.service.RolePermService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: RolePermController类
* @author heaven
* @date 2018/07/02 16:49
*/
@RestController
@RequestMapping("/rolePerm")
public class RolePermController {

    @Resource
    private RolePermService rolePermService;

    @PostMapping("/insert")
    public ApiResult<Integer> insert(RolePerm rolePerm) throws Exception{
        rolePerm.setId(GlobalUtils.getUUID());
        Integer state = rolePermService.insert(rolePerm);
        return ApiResponse.makeOKRsp(state);
    }


    @PostMapping("/deleteById")
    public ApiResult<Integer> deleteById(@RequestParam String id) throws Exception {
            Integer state = rolePermService.deleteById(id);
            return ApiResponse.makeOKRsp(state);
    }

    @PostMapping("/update")
    public ApiResult<Integer> update(RolePerm rolePerm) throws Exception {
            Integer state = rolePermService.update(rolePerm);
            return ApiResponse.makeOKRsp(state);
    }

    @PostMapping("/selectById")
    public ApiResult<RolePerm> selectById(@RequestParam String id) throws Exception {
            RolePerm rolePerm = rolePermService.selectById(id);
             return ApiResponse.makeOKRsp(rolePerm);
    }
    /**
    * @Description: 分页查询
    * @param page 页码
    * @param size 每页条数
    * @Reutrn ApiResult<PageInfo<RolePerm>>
    */
    @PostMapping("/list")
    public ApiResult<PageInfo<RolePerm>> list(@RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<RolePerm> list = rolePermService.selectAll();
        PageInfo<RolePerm> pageInfo = new PageInfo<RolePerm>(list);
        return ApiResponse.makeOKRsp(pageInfo);
    }
 }
