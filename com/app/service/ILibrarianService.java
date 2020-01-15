package com.app.service;

import com.app.pojos.Users;

public interface ILibrarianService {
	Users addMemberDetails(Users u);
	Users editProfile(Users u);
}
