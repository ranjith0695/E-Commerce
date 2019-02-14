package com.ecommerce.dao;

import com.ecommerce.model.User;

public interface UserDAO 
{
	public boolean registeruser(User user);
	public boolean updateaddress(User user);
	public User getUser(String username);

}
