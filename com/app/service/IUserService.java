package com.app.service;

import com.app.pojos.Users;

public interface IUserService {
	Users userAuthenticate(String email,String password); 
}
