package com.ecommerce.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecommerce.dao.CartDAO;
import com.ecommerce.model.CartProduct;

public class CartProductTesting 
{
	static CartDAO cartDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecommerce");
		context.refresh();
		cartDAO= (CartDAO) context.getBean("cartDAO");
	}
	
	@Test
	public void addCartProductTest()
	{
		CartProduct cartproduct=new CartProduct();
		cartproduct.setProductid(83);
		cartproduct.setProductname("T-Shirt");
		cartproduct.setQuantity(5);
		cartproduct.setPrice(500);
		cartproduct.setPaymentstatus("NP");
		cartproduct.setUsername("Ashwin");
		assertTrue("problem in adding to cart",cartDAO.addCartProduct(cartproduct));
	}
    @Ignore
	@Test
	public void deleteCartProduct()
	{
		CartProduct cartproduct=cartDAO.getCartProduct(146);
		assertTrue("problem in deleting cart",cartDAO.deleteCartProduct(cartproduct));

	}
	@Ignore
	@Test
	public void updateCartProduct()
	{
		CartProduct cartproduct=cartDAO.getCartProduct(123);
		cartproduct.setQuantity(25);
		assertTrue("problem in updating cart",cartDAO.updateCartProduct(cartproduct));
	}
	@Ignore
	@Test
	public void listCartProduct()
	{
		List<CartProduct> listCartProduct=cartDAO.listCartProduct("Ashwin");
		assertTrue("problem in displaying cart",listCartProduct.size()>0);
		
		for(CartProduct cartproduct:listCartProduct)
		{
			System.out.println("Cart Id:"+cartproduct.getCartid());
			System.out.println("Product Id:"+cartproduct.getProductid());
			System.out.println("Product Nmae:"+cartproduct.getProductname());
			System.out.println("Price:"+cartproduct.getPrice());
			System.out.println("Quantity:"+cartproduct.getQuantity());
			System.out.println("User Name:"+cartproduct.getUsername());
		}
	}
}
