package com.dxctraining.inventorymgt.supplier.services;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;

import java.util.List;

public interface ISupplierService {
	Supplier findById(int id);
	Supplier addSupplier(Supplier supplier);
	Supplier updateSupplier(Supplier supplier);
	void removeSupplier(int id);
	List<Supplier>listAll();
	boolean authentication(int id, String password);
}
