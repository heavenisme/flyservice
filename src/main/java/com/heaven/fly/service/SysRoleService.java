package com.heaven.fly.service;

import com.heaven.fly.model.SysRole;
import com.heaven.fly.core.common.Service;

import java.util.List;

/**
* @Description: SysRoleService接口
* @author heaven
* @date 2018/07/17 18:03
*/
public interface SysRoleService extends Service<SysRole> {
    List<SysRole> getRolesByRoleId(int roleId);
}