package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Users;
@Repository
public class LibrarianDaoImpl implements ILibrarianDao
{
	@Autowired
	private SessionFactory sf;

	@Override
	public Users addMemberDetails(Users u) {
		sf.getCurrentSession().persist(u);
		return u;
	}

	@Override
	public Users editProfile(Users u) {
		sf.getCurrentSession().update(u);
		return u;
	}

}
