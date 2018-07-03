package com.heaven.fly.dao;

import com.heaven.fly.core.common.Mapper;
import com.heaven.fly.model.UserRole;

import java.util.List;

public interface UserRoleMapper extends Mapper<UserRole> {
    List<String> getRolesByUserId(String userId);
}