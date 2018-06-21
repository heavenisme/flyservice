package com.heaven.fly.dao.db;

import com.heaven.fly.model.SysPermissionInit;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Repository;

@Repository
public interface SysPermissionInitDAO {
    int deleteByPrimaryKey(String id);

    int insert(SysPermissionInit record);

    int insertSelective(SysPermissionInit record);

    SysPermissionInit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysPermissionInit record);

    int updateByPrimaryKey(SysPermissionInit record);
}