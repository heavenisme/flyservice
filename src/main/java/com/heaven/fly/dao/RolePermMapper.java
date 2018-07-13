package com.heaven.fly.dao;

import com.heaven.fly.core.common.Mapper;
import com.heaven.fly.model.RolePerm;

import java.util.List;

public interface RolePermMapper extends Mapper<RolePerm> {
    List<String> getPermsByPermsId(String permsId);
}