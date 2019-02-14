package com.ecommerce.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.dao.UserDAO;
import com.ecommerce.model.Product;
import com.ecommerce.model.Supplier;
import com.ecommerce.model.User;

@Controller
public class UserController
{
	@Autowired 
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;
	
 int i=0;
 
 @RequestMapping("/home")
	public String showhome(Model m)
	{
		i=0;
		m.addAttribute("pageinfo", "home");
		return "home";
	}
 
 @RequestMapping("/logout")
 public String logout(Model m)
 {
	 i=0;
	 m.addAttribute("errmsg", "You Have Logged Out");
	 return "login";
 }

	
	@RequestMapping("/login")
	public String showlogin(Model m)
	{
		i++;
		m.addAttribute("pageinfo", "login");
		if(i>1)
		{
		m.addAttribute("errmsg","Invalid Login Details");
		i=0;
		}
	
		
		else
		{
			i=0;
			m.addAttribute("errmsg", "Enter Login Details");

		}
		             i++;
					return "login";
		
	}
	
	@RequestMapping(value="/userhome")
	public String showuserhome(Model m,HttpSession session)
	{
	     i=0;
		m.addAttribute("errmsg","");
		m.addAttribute("pageinfo", "Product Catalog");
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productList", listProducts);
		
		return "userhome";
	}
	

	@RequestMapping(value="/login_success")
	public String loginCheck(Model m,HttpSession session)
	{
		String page="";
		boolean loggedIn=false;
		
		SecurityContext securityContext=SecurityContextHolder.getContext();
		Authentication authentication=securityContext.getAuthentication();
		
		String username=authentication.getName();
		
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
	
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			
			if(role.getAuthority().equals("Admin"))
			{
				loggedIn=true;
				page="adminhome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
			else
			{
				m.addAttribute("pageinfo", "User Home");
				List<Product> listProducts=productDAO.listProducts();
				m.addAttribute("productList", listProducts);
				
				loggedIn=true;
				page="userhome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
		}
		
		
		return page;
	}
	
	
	@RequestMapping("/register")
	public String showregister(@ModelAttribute("user")User user,Model m)
	{
		m.addAttribute("pageinfo", "register");
		m.addAttribute("user", user);
		return "register";
	}
	

@RequestMapping(value="/registeruser",method=RequestMethod.POST)
	public String registeruser(@ModelAttribute("user")User user,@RequestParam("role")String role,@RequestParam("customerName")String customerName,@RequestParam("customerAddr")String customerAddr,@RequestParam("username")String username,@RequestParam("phonenumber")String phonenumber,@RequestParam("shippingAddr")String shippingAddr ,@RequestParam("password")String password,@RequestParam("enabled")boolean enabled,Model m)
	{
	
		m.addAttribute("user", user);
		user.setCustomerName(customerName);
		user.setCustomerAddr(customerAddr);
		user.setUsername(username);
		user.setPassword(password);
		user.setPhonenumber(phonenumber);
		user.setShippingAddr(shippingAddr);
		user.setEnabled(true);
		user.setRole("User");
		userDAO.registeruser(user);
		m.addAttribute("pageinfo", "Register User");
		
		return "register2";
	}


}
