package com.ecommerce.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.OrderInfo;

@Repository("orderDAO")
@Transactional
public class OrderDAOimpl implements OrderDAO
{
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean saveorder(OrderInfo orderinfo) 
	{
		try
		{
			sessionfactory.getCurrentSession().save(orderinfo);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean updateCart(String username)
	{
		Session session=sessionfactory.getCurrentSession();
		Query query=session.createQuery("update CartProduct set Paymentstatus='P' where username=:uname");
		query.setParameter("uname", username);
		int row_eff=query.executeUpdate();
		if(row_eff>0)
			return true;
		else
		return false;
	}

}
