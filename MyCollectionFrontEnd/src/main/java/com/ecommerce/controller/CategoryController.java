package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.dao.CategoryDAO;
import com.ecommerce.model.Category;

@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/category")
	public String showcategory(Model m)
	{
		Category category=new Category();
		m.addAttribute(category);
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("listCategories", listCategories);
		m.addAttribute("pageinfo", "Manage Category");
		return "category";
	}
	

@RequestMapping(value="/AddCategory",method=RequestMethod.POST)
	public String AddCategory(@ModelAttribute("category")Category category,Model m,@RequestParam("categoryName")String categoryName,@RequestParam("categoryDesc")String categoryDesc)
	{
	
		Category category1=new Category();
		m.addAttribute(category1);
		
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		categoryDAO.addcategory(category);
		
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("listCategories", listCategories);
		m.addAttribute("pageinfo", "Manage Category");
		return "category";
	}

@RequestMapping(value="/deleteCategory/{categoryID}")
public String deleteCategory(Model m,@PathVariable("categoryID")int categoryID)
{
	Category category=categoryDAO.getCategory(categoryID);
	categoryDAO.deletecategory(category);
	
	Category category1=new Category();
	m.addAttribute(category1);
	
	List<Category> listCategories=categoryDAO.listCategories();
	m.addAttribute("listCategories", listCategories);
	m.addAttribute("pageinfo", "Manage Category");
	return "redirect:/category";
}

@RequestMapping(value="editCategory/updatecategory",method=RequestMethod.POST)
public String updatecategory(@ModelAttribute("category")Category category,Model m)
{
	categoryDAO.updatecategory(category);
	
	
	
	List<Category> listCategories=categoryDAO.listCategories();
	m.addAttribute("listCategories", listCategories);
	m.addAttribute("pageinfo", "Manage Category");
	return "redirect:/category";
}
	
@RequestMapping(value="editCategory/{categoryID}")
public String editCategory(Model m,@PathVariable("categoryID")int categoryID)
{
	Category category=categoryDAO.getCategory(categoryID);
	m.addAttribute("category", category );
	m.addAttribute("pageinfo", "Manage Category");
	return "updatecategory";

}
	
}
