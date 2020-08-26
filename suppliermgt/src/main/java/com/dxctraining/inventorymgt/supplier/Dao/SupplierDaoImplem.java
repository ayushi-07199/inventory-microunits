package com.dxctraining.inventorymgt.supplier.Dao;



import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.SupplierException;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class SupplierDaoImplem implements ISupplierDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Supplier findById(int id) {
		Supplier supplier = em.find(Supplier.class, id);
		if(supplier == null) {
			throw new SupplierException("Supplier is null");
		}
		return supplier;
	}

	@Override
	public Supplier addSupplier(Supplier supplier) {
		em.persist(supplier);
		return supplier;
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
		em.merge(supplier);
		return supplier;
	}

	@Override
	public void removeSupplier(int id) {
		Supplier supplier = findById(id);
		em.remove(supplier);
		
	}

	@Override
	public List<Supplier> listAll() {
		String jpaql = "from Supplier";
		TypedQuery<Supplier>query=em.createQuery(jpaql, Supplier.class);
		List<Supplier>listAll=query.getResultList();
		return listAll;
	}


}

