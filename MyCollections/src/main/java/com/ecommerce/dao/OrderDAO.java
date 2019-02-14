package com.ecommerce.dao;

import com.ecommerce.model.OrderInfo;

public interface OrderDAO
{
	public boolean saveorder(OrderInfo orderinfo);
	public boolean updateCart(String username);

}
