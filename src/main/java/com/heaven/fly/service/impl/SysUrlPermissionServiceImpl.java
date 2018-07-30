package com.heaven.fly.service.impl;

import com.heaven.fly.core.common.AbsService;
import com.heaven.fly.dao.SysUrlPermissionMapper;
import com.heaven.fly.model.SysUrlPermission;
import com.heaven.fly.service.SysUrlPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Description: SysUrlPermissionService接口实现类
* @author heaven
* @date 2018/07/30 09:38
*/
@Service
public class SysUrlPermissionServiceImpl extends AbsService<SysUrlPermission> implements SysUrlPermissionService {

    @Resource
    private SysUrlPermissionMapper sysUrlPermissionMapper;

}