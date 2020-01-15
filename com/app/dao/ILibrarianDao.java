package com.app.dao;

import com.app.pojos.Users;

public interface ILibrarianDao 
{
	Users addMemberDetails(Users u);
	Users editProfile(Users u);
}
