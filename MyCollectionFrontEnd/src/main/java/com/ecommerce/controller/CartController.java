package com.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.dao.CartDAO;
import com.ecommerce.dao.ProductDAO;
import com.ecommerce.model.CartProduct;
import com.ecommerce.model.Product;

@Controller
public class CartController 
{
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/cart")
	public String showcart(Model m,HttpSession session) 
	{
		    String username=(String)session.getAttribute("username");	    
		    List<CartProduct> listCartProduct=cartDAO.listCartProduct(username);
			m.addAttribute("CartProductList", listCartProduct);
		    m.addAttribute("TotalAmount", this.getTotalAmount(listCartProduct));
			return "cart";
		
	}
	
	@RequestMapping(value="/addtocart/{productid}")
	public String addtocart(@PathVariable("productid")int productid,@RequestParam("quantity")int quantity,HttpSession session,Model m)
	{
		Product product=productDAO.getProduct(productid);
		String username=(String) session.getAttribute("username");
		
		CartProduct cartproduct=new CartProduct();
		cartproduct.setProductid(product.getProductid());
		cartproduct.setProductname(product.getProductname());
		cartproduct.setQuantity(quantity);
		cartproduct.setPrice(product.getPrice());
		cartproduct.setUsername(username);
		cartproduct.setPaymentstatus("NP");
		cartDAO.addCartProduct(cartproduct);
		List<CartProduct> listCartProduct=cartDAO.listCartProduct(username);
		
		 m.addAttribute("CartProductList", listCartProduct);
		 m.addAttribute("TotalAmount", this.getTotalAmount(listCartProduct));
		
		return "cart";
		
	}
	
	@RequestMapping(value="/updateCartProduct/{cartid}")
	public String updateCartProduct(@PathVariable("cartid")int cartid,@RequestParam("quantity")int quantity,Model m,HttpSession session)
	{
		CartProduct cartproduct=cartDAO.getCartProduct(cartid);
		cartproduct.setQuantity(quantity);
		cartDAO.updateCartProduct(cartproduct);
		

		String username=(String) session.getAttribute("username");
		List<CartProduct> listCartProduct=cartDAO.listCartProduct(username);
		m.addAttribute("CartProductList", listCartProduct);
		 m.addAttribute("TotalAmount", this.getTotalAmount(listCartProduct));
		
		
		return "cart";
	}
	
	@RequestMapping(value="/deleteCartProduct/{cartid}")
	public String deleteCartProduct(@PathVariable("cartid")int cartid,Model m,HttpSession session)
	{
		CartProduct cartproduct=cartDAO.getCartProduct(cartid);
		cartDAO.deleteCartProduct(cartproduct);
		
		String username=(String) session.getAttribute("username");
		List<CartProduct> listCartProduct=cartDAO.listCartProduct(username);
		
		 m.addAttribute("TotalAmount", this.getTotalAmount(listCartProduct));
		m.addAttribute("CartProductList", listCartProduct);
		
		return "cart";
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
