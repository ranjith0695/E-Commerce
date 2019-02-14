package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.Product;
@Repository("productDAO")
@Transactional

public class ProductDAOimpl implements ProductDAO
{
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addproduct(Product product)
	{
		
		try
		{
			sessionfactory.getCurrentSession().save(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteproduct(Product product) 
	{
		try
		{
			sessionfactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean updateproduct(Product product)
	{
		try
		{
			sessionfactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Product> listProducts() 
	{
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> listProducts=query.list();
		session.close();
		return listProducts;
	}

	@Override
	public Product getProduct(int productid)
	{
        Session session=sessionfactory.openSession();
        Product product=session.get(Product.class,productid);
        session.close();
		return product;
	}

}
