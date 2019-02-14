package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.CartProduct;

public interface CartDAO 
{
	public boolean deleteCartProduct(CartProduct cartproduct);
	public boolean updateCartProduct(CartProduct cartproduct);
	public CartProduct  getCartProduct (int cartid);
	
	public List<CartProduct> listCartProduct (String username);
	boolean addCartProduct(CartProduct cartproduct);
}
