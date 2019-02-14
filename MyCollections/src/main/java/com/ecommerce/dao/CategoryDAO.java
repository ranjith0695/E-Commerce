package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.Category;

public interface CategoryDAO 
{
	public boolean addcategory(Category category);
	public boolean deletecategory(Category category);
	public boolean updatecategory(Category category);
	public List<Category> listCategories();
	public Category getCategory(int categoryID);

}
