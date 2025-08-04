package Inv.Manage.App.dao;

import org.springframework.stereotype.Repository;

import Inv.Manage.App.entity.Purchase;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class PurchaseDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void createPurchase(Purchase purchase) {
		entityManager.persist(purchase);
	}
	
}
