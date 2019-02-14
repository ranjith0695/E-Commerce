package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.Product;

public interface ProductDAO 
{
	public boolean addproduct(Product product);
	public boolean deleteproduct(Product product);
	public boolean updateproduct(Product product);
	public List<Product> listProducts();
	public Product getProduct(int productid);

}
