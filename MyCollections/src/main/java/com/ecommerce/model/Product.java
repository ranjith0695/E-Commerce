package com.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
public class Product 
{
	@Id
	@GeneratedValue
	private int productid;
	private String productname;
	private String productdesc;
	private int stock;
	private int price;
	private int categoryID;
	private int supplierID;
	
	@Transient
	MultipartFile pimage;
	
	public MultipartFile getPimage() {
		return pimage;
	}
	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}
	public int getProductid()
	{
		return productid;
	}
	public void setProductid(int productid)
	{
		this.productid = productid;
	}
	public String getProductname() 
	{
		return productname;
	}
	public void setProductname(String productname)
	{
		this.productname = productname;
	}
	public String getProductdesc() 
	{
		return productdesc;
	}
	public void setProductdesc(String productdesc) 
	{
		this.productdesc = productdesc;
	}
	public int getStock() 
	{
		return stock;
	}
	public void setStock(int stock)
	{
		this.stock = stock;
	}
	public int getPrice()
	{
		return price;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	public int getCategoryID()
	{
		return categoryID;
	}
	public void setCategoryID(int categoryID)
	{
		this.categoryID = categoryID;
	}
	public int getSupplierID()
	{
		return supplierID;
	}
	public void setSupplierID(int supplierID) 
	{
		this.supplierID = supplierID;
	}
	

}
