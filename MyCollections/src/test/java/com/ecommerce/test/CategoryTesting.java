package com.ecommerce.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecommerce.dao.CategoryDAO;
import com.ecommerce.model.Category;

public class CategoryTesting 
{
	static CategoryDAO categoryDAO;
	@BeforeClass
	public static void executeFirst() 
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecommerce");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	@Ignore
	@Test
	public void addcategoryTest()
	{
		Category category=new Category();
		category.setCategoryID(3);
		category.setCategoryName("Shirt");
		category.setCategoryDesc("FullSleave");
		assertTrue("Problem in adding Category",categoryDAO.addcategory(category));
	}
	@Ignore
	@Test
	public void deletecategory()
	{
		Category category=categoryDAO.getCategory(0);
		assertTrue("Problem in deleting Category",categoryDAO.deletecategory(category));

	}
	
	@Test
	public void updatecategory()
	{
		Category category=categoryDAO.getCategory(3);
		category.setCategoryDesc("SlimFit");
		category.setCategoryName("FullSleaveShirt");
		assertTrue("Problem in updating Category",categoryDAO.updatecategory(category));

		
	}
	@Ignore
	@Test
	public void listCategories()
	{
		List<Category> listCategories=categoryDAO.listCategories();
		assertTrue("Problem in listing Category",listCategories.size()>0);
		
		for(Category category:listCategories)
		{
			System.out.println("Category Id:"+category.getCategoryID());
			System.out.println("Category Name:"+category.getCategoryName());
			System.out.println("Category Desc:"+category.getCategoryDesc());

		}

	}
	@Test
	public void getCategory()
	{
		Category category=categoryDAO.getCategory(3);
		System.out.println("Category Id:"+category.getCategoryID());
		System.out.println("CategoryName:"+category.getCategoryName());
		System.out.println("CategoryDesc:"+category.getCategoryDesc());

	}
	
	}
