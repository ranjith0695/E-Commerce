package com.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CollectionsController 
{
	
	@RequestMapping("/index1")
	public String showindex1(Model m)
	{
		m.addAttribute("pageinfo", "MyCollections");
		return "index1";
	}
	
	
	
	@RequestMapping("/contactus")
	public String showcontactus(Model m)
	{
		m.addAttribute("pageinfo", "contact us");
		return "contactus";
	}
	
	@RequestMapping("/aboutus")
	public String showaboutus(Model m)
	{
		m.addAttribute("pageinfo", "about us");
		return "aboutus";
	}

}
