package com.heaven.fly.service.impl;

import com.heaven.fly.core.api.ServiceException;
import com.heaven.fly.dao.db.UserInfoDAO;
import com.heaven.fly.model.UserInfo;
import com.heaven.fly.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: heaven
 * @Date: 2018/6/19 17:50
 * @Description:
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDAO userInfoDao;

    public UserInfo selectById(Integer id){
        UserInfo userInfo = userInfoDao.selectById(id);
        if(userInfo == null){
            throw new ServiceException("暂无该用户");
        }
        return userInfo;
    }

}
