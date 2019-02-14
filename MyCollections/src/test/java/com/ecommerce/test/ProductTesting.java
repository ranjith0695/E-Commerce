package com.ecommerce.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.model.Product;

public class ProductTesting
{
	static ProductDAO productDAO;

	@BeforeClass
	public static void executefirst() 
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecommerce");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	@Ignore
	@Test
	public void addproduct()
	{
		Product product=new Product();
		product.setProductname("T-Shirt");
		product.setProductdesc("Jockey Brand");
		product.setPrice(1650);
		product.setStock(25);
		product.setCategoryID(1);
		product.setSupplierID(2);
		assertTrue("problem in adding Product",productDAO.addproduct(product));
	}
	@Ignore
	@Test
	public void deleteproduct()
	{
		Product product=productDAO.getProduct(2);
		assertTrue("problem in adding Product",productDAO.deleteproduct(product));

	}
	@Ignore
	@Test
	public void updateproduct()
	{
		Product product=productDAO.getProduct(3);
		product.setProductname("Pencilfit Jeans");
		product.setStock(15);
		product.setCategoryID(2);
		product.setSupplierID(3);
		assertTrue("problem in updating Product",productDAO.updateproduct(product));

	}
	@Ignore
	@Test
	public void listProducts()
	{
		List<Product> listProducts=productDAO.listProducts();
		assertTrue("problem in listing Product",listProducts.size()>0);
		for(Product product:listProducts)
		{
			System.out.println("productID:"+product.getProductid());
			System.out.println("productName:"+product.getProductname());
			System.out.println("productDesc:"+product.getProductdesc());
			System.out.println("productPrice:"+product.getPrice());
			System.out.println("productStock:"+product.getStock());
			System.out.println("categoryID:"+product.getCategoryID());
			System.out.println("supplierID:"+product.getSupplierID());

		}
		
	}
	@Test
	public void getProduct()
	{
		Product product=productDAO.getProduct(4);
		System.out.println("productID:"+product.getProductid());
		System.out.println("productName:"+product.getProductname());
		System.out.println("productDesc:"+product.getProductdesc());
		System.out.println("productPrice:"+product.getPrice());
		System.out.println("productStock:"+product.getStock());
		System.out.println("categoryID:"+product.getCategoryID());
		System.out.println("supplierID:"+product.getSupplierID());
	}
	

}
