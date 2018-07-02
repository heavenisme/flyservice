package com.heaven.fly.dao;

import com.heaven.fly.core.common.Mapper;
import com.heaven.fly.model.SystemLog;

import java.util.List;

public interface SystemLogMapper extends Mapper<SystemLog> {
    Integer insertByBatch(List<SystemLog> list);
}