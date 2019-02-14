package com.ecommerce.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecommerce.dao.UserDAO;
import com.ecommerce.model.User;

public class TestingUser
{
	static UserDAO userDAO;

	@BeforeClass
	public static void executefirst()
	{
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.ecommerce");
		context.refresh();
		userDAO=(UserDAO) context.getBean("userDAO");
	}
	
	@Test
	public void registeruserTest()
	{
		User user=new User();
		user.setUsername("ranjith66");
		user.setPassword("6397");
		user.setRole("Admin");
		user.setEnabled(true);
		user.setCustomerName("RanjithKumar");
		user.setCustomerAddr("#83;apj abdulkalam street;chennai");
		user.setPhonenumber("9840567895");
		assertTrue("problem in adding user:",userDAO.registeruser(user));
		
	}
	@Ignore
	@Test
	public void updateuser()
	{
		User user=userDAO.getUser("Ashwin");
		user.setRole("User");
		
		assertTrue("problem in updating user:",userDAO.updateaddress(user));
		
	}
	@Ignore
	@Test
	public void getUser()
	{
		User user=userDAO.getUser("ranji");
		System.out.println("UserName: "+user.getUsername());
		System.out.println("Password: "+user.getPassword());
		System.out.println("Role: "+user.getRole());
		System.out.println("CustomerName: "+user.getCustomerName());
		System.out.println("CustomerAddr: "+user.getCustomerAddr());

	}

}
