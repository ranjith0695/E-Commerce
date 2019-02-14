package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.Supplier;

public interface SupplierDAO 
{
	public boolean addsupplier(Supplier supplier);
	public boolean deletesupplier(Supplier supplier);
	public boolean updatesupplier(Supplier supplier);
	List<Supplier> listSuppliers();
	public Supplier getsupplier(int supplierID);
	
}
