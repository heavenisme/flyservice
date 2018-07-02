package com.heaven.fly.service;

import com.heaven.fly.model.UserRole;
import com.heaven.fly.core.common.Service;

import java.util.List;

/**
* @Description: UserRoleService接口
* @author heaven
* @date 2018/07/02 16:37
*/
public interface UserRoleService extends Service<UserRole> {
    List<String> getRolesByUserId(String userId);
}