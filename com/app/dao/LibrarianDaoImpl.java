package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Books;
import com.app.pojos.Copies;
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

	@Override
	public Books addBookDetails(Books b) {
		sf.getCurrentSession().persist(b);
		return b;
	}

	@Override
	public Copies addCopyDetails(Copies c) {
		sf.getCurrentSession().saveOrUpdate(c);
		return c;
	}

	@Override
	public List<Users> listAllUsers() {
		String jpql = "select u from Users u";
		return sf.getCurrentSession().createQuery(jpql, Users.class).getResultList();
	}

}
