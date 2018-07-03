package com.heaven.fly.dao;

import com.heaven.fly.core.common.Mapper;
import com.heaven.fly.model.SysPermissionInit;

import java.util.List;

public interface SysPermissionInitMapper extends Mapper<SysPermissionInit> {
    List<SysPermissionInit> selectAllOrderBySort();
}