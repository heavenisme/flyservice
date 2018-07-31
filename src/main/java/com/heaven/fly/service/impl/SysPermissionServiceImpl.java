package com.heaven.fly.service.impl;

import com.heaven.fly.dao.SysPermissionMapper;
import com.heaven.fly.model.sys.SysPermission;
import com.heaven.fly.service.SysPermissionService;
import com.heaven.fly.core.common.AbsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Description: SysPermissionService接口实现类
* @author heaven
* @date 2018/07/18 17:46
*/
@Service
public class SysPermissionServiceImpl extends AbsService<SysPermission> implements SysPermissionService {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

}