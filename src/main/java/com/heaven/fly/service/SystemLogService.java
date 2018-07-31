package com.heaven.fly.service;

import com.heaven.fly.model.sys.SystemLog;
import com.heaven.fly.core.common.Service;

import java.util.List;

/**
* @Description: SystemLogService接口
* @author heaven
* @date 2018/07/02 16:28
*/
public interface SystemLogService extends Service<SystemLog> {
    Integer insertByBatch(List<SystemLog> list);
}