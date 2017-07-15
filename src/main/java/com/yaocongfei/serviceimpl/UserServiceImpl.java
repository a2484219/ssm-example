package com.yaocongfei.serviceimpl;

import com.yaocongfei.dao.UserMapper;
import com.yaocongfei.model.User;
import com.yaocongfei.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private UserMapper userMapper;

	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userMapper.selectById();
	}

}
