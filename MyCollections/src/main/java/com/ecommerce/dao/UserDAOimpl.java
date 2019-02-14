package com.ecommerce.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.User;
@Repository("userDAO")
@Transactional
public class UserDAOimpl implements UserDAO
{
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean registeruser(User user)
	{
		try
		{
			sessionfactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			return false;

		}
	}

	@Override
	public boolean updateaddress(User user) 
	{
		try
		{
			sessionfactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			return false;

		}
	}

	@Override
	public User getUser(String username)
	{
		Session session=sessionfactory.openSession();
		User user=session.get(User.class, username);
		session.close();
		return user;
	}

}
