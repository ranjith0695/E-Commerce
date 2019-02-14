package com.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.dao.CartDAO;
import com.ecommerce.dao.OrderDAO;
import com.ecommerce.dao.ProductDAO;
import com.ecommerce.dao.UserDAO;
import com.ecommerce.model.CartProduct;
import com.ecommerce.model.OrderInfo;
import com.ecommerce.model.User;

@Controller
public class PaymentController
{
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	OrderDAO orderDAO;
		
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/checkout")
	public String checkout(Model m,HttpSession session)
	{
		 String username=(String)session.getAttribute("username");	    
		    List<CartProduct> listCartProduct=cartDAO.listCartProduct(username);
			m.addAttribute("CartProductList", listCartProduct);
		    m.addAttribute("TotalAmount", this.getTotalAmount(listCartProduct));
		    
		    User user=userDAO.getUser(username);
		    String address=userDAO.getUser(username).getCustomerAddr();
		    m.addAttribute("addr", address);
		    userDAO.getUser(username);
		    String saddress=userDAO.getUser(username).getShippingAddr();
		    m.addAttribute("saddr", saddress);
		    return "orderconform";
		    
	}
	
	@RequestMapping(value="/updateaddress",method=RequestMethod.POST)
	public String updateaddress(@RequestParam("saddr")String saddr,Model m,HttpSession session )
	{

		String username=(String)session.getAttribute("username");	    
	    List<CartProduct> listCartProduct=cartDAO.listCartProduct(username);
	   
	    m.addAttribute("CartProductList", listCartProduct);
	    m.addAttribute("TotalAmount", this.getTotalAmount(listCartProduct));
	    
		User user=userDAO.getUser(username);
		user.setShippingAddr(saddr);
	    userDAO.updateaddress(user);

	   String address=user.getCustomerAddr();
	   
	    m.addAttribute("addr",address);
	    String saddress=user.getShippingAddr();
	    m.addAttribute("saddr", saddress);
		
		return "orderconform";
	}
	
	@RequestMapping(value="/payment")
	public String PaymentPage(Model m,HttpSession session)
	{
		
	return "payment";
		
	}
	

	@RequestMapping(value="/receipt",method=RequestMethod.POST)
	public String generateReceipt(@RequestParam ("Pmode")String Pmode,Model m,HttpSession session) 
	{
		String username=(String)session.getAttribute("username");

		OrderInfo orderinfo=new OrderInfo();
		orderinfo.setOrderdate(new java.util.Date());
		orderinfo.setShippingAddr(userDAO.getUser(username).getShippingAddr());
		orderinfo.setTranstype(Pmode);
		orderinfo.setUsername(username);
		
		   List<CartProduct> listCartProduct=cartDAO.listCartProduct(username);
		   
		    m.addAttribute("CartProductList", listCartProduct);
		    m.addAttribute("TotalAmount", this.getTotalAmount(listCartProduct));
		    
			User user=userDAO.getUser(username);
		
		
		orderinfo.setTotalprice(this.getTotalAmount(listCartProduct));
		   String address=user.getCustomerAddr();
		   
		    m.addAttribute("addr",address);
		    String saddress=user.getShippingAddr();
		    m.addAttribute("saddr", saddress);
		    
		orderDAO.saveorder(orderinfo);
		orderDAO.updateCart(username);
		m.addAttribute("orderInfo", orderinfo);
		
		
		return "receipt";
	}
		
	
	 public int getTotalAmount(List<CartProduct> listCartProduct)
	 {
		 int TotalAmount=0,count=0;
		 
		 
		 while(count<listCartProduct.size())
		 {
			 TotalAmount=TotalAmount+(listCartProduct.get(count).getQuantity()*listCartProduct.get(count).getPrice());
			 count++;
		 }
		 
		 return TotalAmount; 
	 }

}
