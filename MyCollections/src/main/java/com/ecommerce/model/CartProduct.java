package com.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CartProduct
{
	@Id
	@GeneratedValue
	int cartid;

	
	int productid;
	int quantity;
	int price;
	String username;
	String productname;
	String paymentstatus;
	
	
	public int getCartid() 
	{
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public int getProductid() 
	{
		return productid;
	}
	public void setProductid(int productid)
	{
		this.productid = productid;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public int getPrice() 
	{
		return price;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	public String getProductname() 
	{
		return productname;
	}
	public void setProductname(String productname)
	{
		this.productname = productname;
	}
	public String getPaymentstatus()
	{
		return paymentstatus;
	}
	public void setPaymentstatus(String paymentstatus)
	{
		this.paymentstatus = paymentstatus;
	}

}
