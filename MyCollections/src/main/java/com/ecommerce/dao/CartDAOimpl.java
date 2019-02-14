package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.CartProduct;


@Transactional
@Repository("cartDAO")
public class CartDAOimpl implements CartDAO
{
	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean addCartProduct(CartProduct cartproduct)
	{
		try
		{
			sessionfactory.getCurrentSession().save(cartproduct);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean deleteCartProduct(CartProduct cartproduct)
	{
		try
		{
			sessionfactory.getCurrentSession().delete(cartproduct);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean updateCartProduct(CartProduct cartproduct) 
	{
		try
		{
			sessionfactory.getCurrentSession().update(cartproduct);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public CartProduct getCartProduct(int cartid)
	{
		Session session=sessionfactory.openSession();
		CartProduct cartproduct=session.get(CartProduct.class,cartid );
		session.close();
		return cartproduct;
	}

	@Override
	public List<CartProduct> listCartProduct(String username)
	{

		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from CartProduct where username=:username and paymentStatus='NP'");
		query.setParameter("username",username);
		List<CartProduct> listCartProduct=query.getResultList();
		session.close();
		return listCartProduct;

	}

	

}
