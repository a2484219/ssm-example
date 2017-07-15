package com.yaocongfei.dao;

import com.yaocongfei.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectById();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}