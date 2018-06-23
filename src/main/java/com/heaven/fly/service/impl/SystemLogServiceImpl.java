package com.heaven.fly.service.impl;

import com.heaven.fly.dao.SystemLogMapper;
import com.heaven.fly.model.SystemLog;
import com.heaven.fly.service.SystemLogService;
import com.heaven.fly.core.common.AbsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @Description: SystemLogService接口实现类
* @author heaven
* @date 2018/06/23 10:42
*/
@Service
public class SystemLogServiceImpl extends AbsService<SystemLog> implements SystemLogService {

    @Resource
    private SystemLogMapper systemLogMapper;

}