package com.dxctraining.inventorymgt.supplier.services;


import com.dxctraining.inventorymgt.supplier.Dao.ISupplierDao;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.InvalidArgumentException;
import com.dxctraining.inventorymgt.supplier.exceptions.SupplierException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class SupplierServiceImple implements ISupplierService {
	@Autowired
	private ISupplierDao dao;
	
	@Override
	public Supplier findById(int id) {
		validateId(id);
		Supplier supplier = dao.findById(id);
		return supplier;
	}
	
	private void validateId(int id) {
		if(id == 0) {
			throw new InvalidArgumentException("id should not be null");
		}
		
	}

	@Override
	public Supplier addSupplier(Supplier supplier) {
		validateSupplier(supplier);
		dao.addSupplier(supplier);
		return supplier;
	}

	private void validateSupplier(Supplier supplier) {
		if(supplier == null) {
			throw new SupplierException("supplier is null");
		}
		
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
		validateSupplier(supplier);
		dao.updateSupplier(supplier);
		return supplier;
	}


	@Override
	public void removeSupplier(int id) {
		validateId(id);
		dao.removeSupplier(id);
		
	}

	@Override
	public List<Supplier> listAll() {
		List<Supplier>listAll= dao.listAll();
		return listAll;
	}

	@Override
	public boolean authentication(int id, String password) {
		Supplier supplier = dao.findById(id);
		String fetchedpassword = supplier.getPassword();
		boolean equals = fetchedpassword.equals(password);
		return equals;
	}

}
