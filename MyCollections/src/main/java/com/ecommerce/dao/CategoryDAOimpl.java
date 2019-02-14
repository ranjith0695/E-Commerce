package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ecommerce.model.Category;
@Repository("categoryDAO")
@Transactional
public class CategoryDAOimpl implements CategoryDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addcategory(Category category)
	{ 
		try
		{
			sessionFactory.getCurrentSession().save(category);
			return true;
		}
		catch(Exception e) 
		{
			return false;
		}
	}

	@Override
	public boolean deletecategory(Category category)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e) 
		{
			return false;
		}
	}

	@Override
	public boolean updatecategory(Category category)
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
		
			session.update(category);
		
			return true;
		}
		catch(Exception e) 
		{
			return false;
		}
	}

	@Override
	public List<Category> listCategories() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> listCategories= query.list();
		session.close();
		return listCategories;
	}

	@Override
	public Category getCategory(int categoryID)
	{
		Session session=sessionFactory.openSession();
		Category category=session.get(Category.class, categoryID);
		session.close();
		return category;
	}

}
