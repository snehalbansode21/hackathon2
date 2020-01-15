package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.Users;

@Service
@Transactional
public class UserServiceImpl implements IUserService
{
	@Autowired
	private IUserDao dao;
	@Override
	public Users userAuthenticate(String email, String password) {
		return dao.userAuthenticate(email, password);
	}

}
