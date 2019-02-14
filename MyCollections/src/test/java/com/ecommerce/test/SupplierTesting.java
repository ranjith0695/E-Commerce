package com.ecommerce.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecommerce.dao.SupplierDAO;
import com.ecommerce.model.Supplier;

public class SupplierTesting 
{
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void executefirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecommerce");
		context.refresh();
		supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
	}
	@Ignore
	@Test
	public void addsupplier() 
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierID(2);
		supplier.setSupplierName("CrazyCollections");
		supplier.setSupplierAddr("Chennai");
		assertTrue("Problem in adding Supplier",supplierDAO.addsupplier(supplier));

	}
	@Ignore
	@Test
	public void deletesupplier()
	{
		Supplier supplier=supplierDAO.getsupplier(2);
		assertTrue("Problem in deleting Supplier",supplierDAO.deletesupplier(supplier));

	}
	@Ignore
	@Test
	public void updatesupplier()
	{
		Supplier supplier=supplierDAO.getsupplier(3);
		supplier.setSupplierName("BobFashions");
		supplier.setSupplierAddr("Delhi");
		assertTrue("Problem in updating Supplier",supplierDAO.updatesupplier(supplier));
    }
	@Ignore
	@Test
	public void listsuppliers()
	{
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		assertTrue("Problem in listing Supplier",listSuppliers.size()>0);
		
		for(Supplier supplier:listSuppliers)
		{
			System.out.println("SupplierID:"+supplier.getSupplierID());
			System.out.println("SupplierADDR:"+supplier.getSupplierAddr());
			System.out.println("SupplierNAME:"+supplier.getSupplierName());
		}

	}
	@Test
	public void getSupplier()
	{
		Supplier supplier=supplierDAO.getsupplier(2);
		System.out.println("SupplierID:"+supplier.getSupplierID());
		System.out.println("SupplierADDR:"+supplier.getSupplierAddr());
		System.out.println("SupplierNAME:"+supplier.getSupplierName());
	}
	
	}


