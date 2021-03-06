package com.heaven.fly.service.impl;

import com.heaven.fly.dao.SysRoleMapper;
import com.heaven.fly.model.sys.SysRole;
import com.heaven.fly.service.SysRoleService;
import com.heaven.fly.core.common.AbsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Description: SysRoleService接口实现类
* @author heaven
* @date 2018/07/29 16:28
*/
@Service
public class SysRoleServiceImpl extends AbsService<SysRole> implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

}