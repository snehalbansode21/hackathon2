package com.app.dao;

import com.app.pojos.Users;

public interface IUserDao {
	Users userAuthenticate(String email,String password);
}
