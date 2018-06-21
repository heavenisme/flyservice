package com.heaven.fly.dao.db;

import com.heaven.fly.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserInfoDAO继承基类
 */
public interface UserInfoDAO {
    UserInfo selectById(@Param("id") Integer id);

    List<UserInfo> selectAll();
}