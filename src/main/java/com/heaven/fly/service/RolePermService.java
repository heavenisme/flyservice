package com.heaven.fly.service;

import com.heaven.fly.model.RolePerm;
import com.heaven.fly.core.common.Service;

import java.util.List;

/**
* @Description: RolePermService接口
* @author heaven
* @date 2018/07/02 16:49
*/
public interface RolePermService extends Service<RolePerm> {
    List<String> getPermsByUserId(String userId);
}