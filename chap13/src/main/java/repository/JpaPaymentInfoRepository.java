package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.orm.jpa.EntityManagerFactoryAccessor;

import model.PaymentInfo;

public class JpaPaymentInfoRepository implements PaymentInfoRepository{

	@PersistenceUnit //와이어링
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public void save(PaymentInfo paymentInfo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.joinTransaction();
		entityManager.persist(paymentInfo);
	}
	
}
