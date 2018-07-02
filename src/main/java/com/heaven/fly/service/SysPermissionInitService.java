package com.heaven.fly.service;

import com.heaven.fly.model.SysPermissionInit;
import com.heaven.fly.core.common.Service;

import java.util.List;

/**
* @Description: SysPermissionInitService接口
* @author heaven
* @date 2018/07/02 17:28
*/
public interface SysPermissionInitService extends Service<SysPermissionInit> {
    List<SysPermissionInit> selectAllOrderBySort();
}