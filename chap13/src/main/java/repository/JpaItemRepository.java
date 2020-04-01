package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.Item;

public class JpaItemRepository implements ItemRepository {

	private EntityManagerFactory entityManagerFactory;
	
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.entityManagerFactory = emf;
	}
	
	@Override
	public Item findById(Integer itemId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.joinTransaction();
		return entityManager.find(Item.class, itemId);
	}
}
