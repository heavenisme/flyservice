package com.heaven.fly.service;

import com.github.pagehelper.PageInfo;
import com.heaven.fly.core.common.Service;
import com.heaven.fly.model.UserInfo;

import java.util.List;

/**
 * @Auther: heaven
 * @Date: 2018/6/19 17:41
 * @Description:
 */

public interface UserInfoService extends Service<UserInfo> {
    List<UserInfo> selectAlla(int page, int size);
}
