package com.app.service;

import java.util.List;

import com.app.pojos.Books;
import com.app.pojos.Copies;
import com.app.pojos.Users;

public interface ILibrarianService {
	Users addMemberDetails(Users u);
	Users editProfile(Users u);
	Books addBookDetails(Books b);
	Copies addCopyDetails(Copies c);
	List<Users> listAllUsers();
}
