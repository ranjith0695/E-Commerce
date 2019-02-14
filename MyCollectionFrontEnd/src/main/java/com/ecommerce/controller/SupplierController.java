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

import com.ecommerce.dao.SupplierDAO;
import com.ecommerce.model.Supplier;

@Controller
public class SupplierController 
{
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping("/supplier")
	public String showsupplier(Model m)
	{
		Supplier supplier=new Supplier();
		m.addAttribute(supplier);
		List<Supplier>listSuppliers=supplierDAO.listSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);
		m.addAttribute("pageinfo", "Manage Supplier");
		return "supplier";
	}
	

@RequestMapping(value="/AddSupplier",method=RequestMethod.POST)
	public String AddSupplier(@ModelAttribute("supplier")Supplier supplier,@RequestParam("supplierName")String supplierName,@RequestParam("supplierAddr")String supplierAddr,Model m)
	{
	;
		
		Supplier supplier1=new Supplier();
		m.addAttribute(supplier1);
		
		supplier.setSupplierName(supplierName);
		supplier.setSupplierAddr(supplierAddr);
		supplierDAO.addsupplier(supplier);
		m.addAttribute("pageinfo", "Manage Supplier");
		List<Supplier>listSuppliers=supplierDAO.listSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);
		m.addAttribute("pageinfo", "Manage Supplier");
		return "supplier";
	}

@RequestMapping(value="/deleteSupplier/{supplierID}")
public String deleteSupplier(Model m,@PathVariable("supplierID")int supplierID)
{
	Supplier supplier=supplierDAO.getsupplier(supplierID);
	supplierDAO.deletesupplier(supplier);
	
	Supplier supplier1=new Supplier();
	m.addAttribute(supplier1);
	
	List<Supplier>listSuppliers=supplierDAO.listSuppliers();
	m.addAttribute("listSuppliers", listSuppliers);
	m.addAttribute("pageinfo", "Manage Supplier");
	return "redirect:/supplier";
}

@RequestMapping(value="editSupplier/updatesupplier",method=RequestMethod.POST)
public String updatesupplier(@ModelAttribute("supplier")Supplier supplier,Model m,@RequestParam("supplierName")String supplierName,@RequestParam("supplierAddr")String supplierAddr)
{
	Supplier supplier1=new Supplier();
	m.addAttribute(supplier1);
	
	supplier.setSupplierName(supplierName);
	supplier.setSupplierAddr(supplierAddr);
	supplierDAO.updatesupplier(supplier);
	
	List<Supplier>listSuppliers=supplierDAO.listSuppliers();
	m.addAttribute("listSuppliers", listSuppliers);
	m.addAttribute("pageinfo", "Manage Supplier");
	return "redirect:/supplier";
}

@RequestMapping(value="/editSupplier/{supplierID}")
public String editSupplier(Model m,@PathVariable("supplierID")int supplierID)
{
	Supplier supplier = supplierDAO.getsupplier(supplierID);
		
	m.addAttribute("supplier", supplier);
	m.addAttribute("pageinfo", "Manage Supplier");
	return "updatesupplier";
}

}
