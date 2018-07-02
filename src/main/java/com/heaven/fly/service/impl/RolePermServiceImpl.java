package com.heaven.fly.service.impl;

import com.heaven.fly.dao.RolePermMapper;
import com.heaven.fly.model.RolePerm;
import com.heaven.fly.service.RolePermService;
import com.heaven.fly.core.common.AbsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: RolePermService接口实现类
* @author heaven
* @date 2018/07/02 16:49
*/
@Service
public class RolePermServiceImpl extends AbsService<RolePerm> implements RolePermService {

    @Resource
    private RolePermMapper rolePermMapper;

    public List<String> getPermsByUserId(String userId){
        return rolePermMapper.getPermsByUserId(userId);
    }
}