package com.heaven.fly.service.impl;

import com.heaven.fly.dao.SysPermissionInitMapper;
import com.heaven.fly.model.SysPermissionInit;
import com.heaven.fly.service.SysPermissionInitService;
import com.heaven.fly.core.common.AbsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: SysPermissionInitService接口实现类
* @author heaven
* @date 2018/07/02 17:28
*/
@Service
public class SysPermissionInitServiceImpl extends AbsService<SysPermissionInit> implements SysPermissionInitService {

    @Resource
    private SysPermissionInitMapper sysPermissionInitMapper;

    @Override
    public List<SysPermissionInit> selectAllOrderBySort(){
        return sysPermissionInitMapper.selectAllOrderBySort();
    }

}