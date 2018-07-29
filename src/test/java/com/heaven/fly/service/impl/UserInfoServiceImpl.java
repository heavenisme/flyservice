package com.heaven.fly.service.impl;

import com.heaven.fly.dao.UserInfoMapper;
import com.heaven.fly.model.UserInfo;
import com.heaven.fly.service.UserInfoService;
import com.heaven.fly.core.common.AbsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @Description: UserInfoService接口实现类
* @author heaven
* @date 2018/07/29 16:23
*/
@Service
public class UserInfoServiceImpl extends AbsService<UserInfo> implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

}