package com.ecommerce.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.dao.CategoryDAO;
import com.ecommerce.dao.ProductDAO;
import com.ecommerce.dao.SupplierDAO;
import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.model.Supplier;

@Controller
public class ProductController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping("/product")
	public String showproduct(Model m)
	{
		Product product=new Product();
		m.addAttribute(product);
		List<Product>listProducts=productDAO.listProducts();
		m.addAttribute("productList",listProducts );
		m.addAttribute("catList", this.getCategories());
		m.addAttribute("supList", this.getSuppliers());
		m.addAttribute("pageinfo", "Manage Product");
		return "product";
	}
	
	@PostMapping(value="/InsertProduct")
	public String InsertProduct(@ModelAttribute("product")Product product,@RequestParam("pimage")MultipartFile filedet,Model m)
	{
	    productDAO.addproduct(product);
		
		Product product1=new Product();
	    m.addAttribute(product1);
	    m.addAttribute("pageinfo","Manage Product");
	    m.addAttribute("catList", this.getCategories());
	    m.addAttribute("supList",this.getSuppliers());
	    String imagepath="C:\\Users\\Gopi\\eclipse-workspace\\MyCollectionFrontEnd\\src\\main\\webapp\\resources\\images\\";
	    imagepath=imagepath+String.valueOf(product.getProductid())+".jpg";
	    File image=new File(imagepath);
	    
	    if(!filedet.isEmpty())
	    {
	    	try
	    	{
	    		byte buff[]=filedet.getBytes();
	    		FileOutputStream fos=new FileOutputStream(image);
	    		BufferedOutputStream bos=new BufferedOutputStream(fos);
	    		bos.write(buff);
	    		bos.close();
	    		
	    	}
	    	catch(Exception e)
	    	{
	    		m.addAttribute("Exception message","Exception in uploading the image:"+e.getMessage());
	    		
	    	}
	    }
	    else
	    {
	    	m.addAttribute("error message", "problem in uploading the image:");
	    }
	    
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productList", listProducts);
		
	
		return "product";
	}
	
	@RequestMapping(value="editProduct/updateproduct",method=RequestMethod.POST)
	public String updateproduct(@ModelAttribute("product")Product product,Model m)
	{
		productDAO.updateproduct(product);
		Product product1=new Product();
		m.addAttribute(product1);
				
		m.addAttribute("pageinfo","Manage product");
		m.addAttribute("catList",this.getCategories());
		 m.addAttribute("supList",this.getSuppliers());
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productList", listProducts);

		return "redirect:/product";
	}
	
	@RequestMapping("/productdisplay")
	public String displayAllProducts(@ModelAttribute("product")Product product,Model m)
	{
		m.addAttribute("pageinfo", "Product Catalogs");
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productList", listProducts);

		return "productdisplay";
	}
	
	@RequestMapping(value="/totalProductDisplay/{productid}")
	public String totalProductDisplay(Model m,@PathVariable("productid")int productid)
	{
		m.addAttribute("pageinfo", "Product Info");
		Product product=productDAO.getProduct(productid);
		m.addAttribute("product", product);
		return "totalProductDisplay";
	}
	
	@RequestMapping(value="/deleteProduct/{productid}")
	public String deleteProduct(Model m,@PathVariable("productid")int productid)
	{
		Product product=productDAO.getProduct(productid);
		productDAO.deleteproduct(product);
		
		Product product1=new Product();
		m.addAttribute(product1);
			
		m.addAttribute("pageinfo","Manage product");
		m.addAttribute("catList",this.getCategories());
		 m.addAttribute("supList",this.getSuppliers());
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productList", listProducts);

		return "redirect:/product";
		}
	
	@RequestMapping(value="/editProduct/{productid}")
	public String editProduct(Model m,@PathVariable("productid")int productid)
	{
	       
		Product product=productDAO.getProduct(productid);
		m.addAttribute("product", product);
		
		
		m.addAttribute("pageinfo","Manage product");
		m.addAttribute("catList",this.getCategories());
		
		return"updateproduct";
		
	}
	
		
	public LinkedHashMap<Integer,String> getCategories()
	{
		List<Category> listCategories=categoryDAO.listCategories();
		LinkedHashMap<Integer,String> catList=new LinkedHashMap<Integer,String>();
		for(Category category:listCategories)
		{
			catList.put(category.getCategoryID(), category.getCategoryName());
		}
			return catList;	
}
	
	public LinkedHashMap<Integer,String> getSuppliers()
	{
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		LinkedHashMap<Integer,String> supList=new LinkedHashMap<Integer,String>();
		for(Supplier supplier:listSuppliers)
		{
			supList.put(supplier.getSupplierID(),supplier.getSupplierName() );
		}
			return supList;	
}
	
}
