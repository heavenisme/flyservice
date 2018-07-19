package com.heaven.fly.dao;

import com.heaven.fly.core.common.Mapper;
import com.heaven.fly.model.SysRole;

import java.util.List;

public interface SysRoleMapper extends Mapper<SysRole> {
    List<SysRole> getRolesByRoleId(int id);
}