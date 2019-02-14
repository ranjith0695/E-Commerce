package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOimpl implements SupplierDAO
{
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addsupplier(Supplier supplier)
	{
		try
		{
			sessionfactory.getCurrentSession().save(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
		
	}

	@Override
	public boolean deletesupplier(Supplier supplier)
	{
		try
		{
			sessionfactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
		
	}
	@Override
	public boolean updatesupplier(Supplier supplier) 
	{
		try
		{
			sessionfactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
		
	}

	@Override
	public List<Supplier> listSuppliers() 
	{
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> listSuppliers=query.list();
		session.close();
		return listSuppliers;
	}

	@Override
	public Supplier getsupplier(int supplierID)
	{
		Session session=sessionfactory.openSession();
		Supplier supplier=session.get(Supplier.class, supplierID);
		session.close();
		return supplier;
	}

}
