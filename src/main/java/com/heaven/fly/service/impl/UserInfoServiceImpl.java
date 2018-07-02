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

    public UserInfo selectById(Integer id){
        UserInfo userInfo = userInfoDao.selectByPrimaryKey(id);
        if(userInfo == null){
            throw new ServiceException("暂无该用户");
        }
        return userInfo;
    }

    @Override
    public List<UserInfo> selectAll(Integer page, Integer size) {
        //开启分页查询，写在查询语句上方
        //只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select）方法会被分页。
//        PageHelper.startPage(page, size);
        List<UserInfo> userInfoList = userInfoDao.selectAll(page,size);
//        PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfoList);
        return userInfoList;
    }

}
