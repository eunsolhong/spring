package repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.PurchaseOrder;

public class JpaPurchaseOrderRepository implements PurchaseOrderRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void save(PurchaseOrder order) {
		entityManager.persist(order);
	}
}
