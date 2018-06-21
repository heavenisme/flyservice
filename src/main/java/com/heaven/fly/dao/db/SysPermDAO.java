package com.heaven.fly.dao.db;

import com.heaven.fly.model.SysPerm;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Repository;

@Repository
public interface SysPermDAO {
    int deleteByPrimaryKey(String id);

    int insert(SysPerm record);

    int insertSelective(SysPerm record);

    SysPerm selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysPerm record);

    int updateByPrimaryKey(SysPerm record);
}