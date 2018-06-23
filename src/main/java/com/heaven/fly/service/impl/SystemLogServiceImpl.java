package com.heaven.fly.service.impl;

import com.heaven.fly.dao.db.SystemLogMapper;
import com.heaven.fly.model.SystemLog;
import com.heaven.fly.service.SystemLogService;
import com.heaven.fly.core.common.AbsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: SystemLogService接口实现类
* @author heaven
* @date 2018/06/23 11:12
*/
@Service
public class SystemLogServiceImpl extends AbsService<SystemLog> implements SystemLogService {

    @Resource
    private SystemLogMapper systemLogMapper;

    @Override
    public Integer insertByBatch(List<SystemLog> list) {
        return systemLogMapper.insertByBatch(list);
    }

}