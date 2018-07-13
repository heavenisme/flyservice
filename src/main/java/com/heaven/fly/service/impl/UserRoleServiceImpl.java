package com.heaven.fly.service.impl;

import com.heaven.fly.dao.UserRoleMapper;
import com.heaven.fly.model.UserRole;
import com.heaven.fly.service.UserRoleService;
import com.heaven.fly.core.common.AbsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: UserRoleService接口实现类
* @author heaven
* @date 2018/07/02 16:37
*/
@Service
public class UserRoleServiceImpl extends AbsService<UserRole> implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    public List<String> getRolesByRolesId(String rolesId){
        return userRoleMapper.getRolesByUserId(rolesId);
    }
}