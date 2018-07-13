package com.heaven.fly.dao;

import com.heaven.fly.core.common.Mapper;
import com.heaven.fly.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserInfoDAO继承基类
 */
public interface UserInfoDAO extends Mapper<UserInfo> {
}