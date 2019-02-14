package com.ecommerce.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecommerce.dao.OrderDAO;
import com.ecommerce.model.OrderInfo;

public class OrderTesting 
{
	
static OrderDAO orderDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecommerce");
		context.refresh();	
		orderDAO=(OrderDAO)context.getBean("orderDAO");
	}
	
	@Test
	public void saveorderTest()
	{
          OrderInfo orderinfo=new OrderInfo();
          orderinfo.setOrderdate(new java.util.Date());
  		orderinfo.setCartid(390);
  		orderinfo.setShippingAddr("chennai");
  		orderinfo.setTotalprice(990);
  		orderinfo.setTranstype("CC");
  		orderinfo.setUsername("Ashwin");
		
		assertTrue("Problem in saving",orderDAO.saveorder(orderinfo));
	}
	
	@Ignore
	@Test
	public void updateCart()
	{
		assertTrue("problem in Updating Cart",orderDAO.updateCart("Ashwin"));
		
	}
}
