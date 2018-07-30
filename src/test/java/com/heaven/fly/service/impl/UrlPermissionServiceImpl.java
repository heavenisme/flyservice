package com.heaven.fly.service.impl;

import com.heaven.fly.dao.UrlPermissionMapper;
import com.heaven.fly.model.UrlPermission;
import com.heaven.fly.service.UrlPermissionService;
import com.heaven.fly.core.common.AbsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @Description: UrlPermissionService接口实现类
* @author heaven
* @date 2018/07/30 09:28
*/
@Service
public class UrlPermissionServiceImpl extends AbsService<UrlPermission> implements UrlPermissionService {

    @Resource
    private UrlPermissionMapper urlPermissionMapper;

}