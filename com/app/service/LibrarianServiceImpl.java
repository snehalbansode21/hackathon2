package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ILibrarianDao;
import com.app.pojos.Books;
import com.app.pojos.Copies;
import com.app.pojos.Users;

@Service
@Transactional
public class LibrarianServiceImpl implements ILibrarianService
{
	@Autowired
	private ILibrarianDao dao;
	
	@Override
	public Users addMemberDetails(Users u) {
		return dao.addMemberDetails(u);
	}
	@Override
	public Users editProfile(Users u) {
		return dao.editProfile(u);
	}
	@Override
	public Books addBookDetails(Books b) {
		return dao.addBookDetails(b);
	}
	@Override
	public Copies addCopyDetails(Copies c) {
		return dao.addCopyDetails(c);
	}
	@Override
	public List<Users> listAllUsers() {
		return dao.listAllUsers();
	}

}
