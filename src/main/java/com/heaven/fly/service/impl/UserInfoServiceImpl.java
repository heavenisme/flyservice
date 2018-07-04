package com.heaven.fly.service.impl;

import com.heaven.fly.core.api.ServiceException;
import com.heaven.fly.core.common.AbsService;
import com.heaven.fly.dao.UserInfoDAO;
import com.heaven.fly.model.UserInfo;
import com.heaven.fly.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: heaven
 * @Date: 2018/6/19 17:50
 * @Description:
 */
@Service
public class UserInfoServiceImpl  extends AbsService<UserInfo> implements UserInfoService {

    @Resource
    private UserInfoDAO userInfoDao;

    @Override
    public UserInfo selectById(String id){
        UserInfo userInfo = userInfoDao.selectByPrimaryKey(id);
        if(userInfo == null){
            throw new ServiceException("暂无该用户");
        }
        return userInfo;
    }

    @Override
    public List<UserInfo> selectAlla(int pageNum, int pageSize) {
        return userInfoDao.selectAll(pageNum,pageSize);
    }

}
