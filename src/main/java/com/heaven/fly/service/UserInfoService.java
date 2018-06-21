package com.heaven.fly.service;

import com.heaven.fly.model.UserInfo;

/**
 * @Auther: heaven
 * @Date: 2018/6/19 17:41
 * @Description:
 */

public interface UserInfoService {
    UserInfo selectById(Integer id);
}
