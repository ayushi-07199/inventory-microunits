package com.dxctraining.inventorymgt.supplier.Dao;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;

import java.util.List;

public interface ISupplierDao {
	Supplier findById(int id);
	Supplier addSupplier(Supplier supplier);
	Supplier updateSupplier(Supplier supplier);
	void removeSupplier(int id);
	List<Supplier> listAll();
}
