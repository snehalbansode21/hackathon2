package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ILibrarianDao;
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

}
