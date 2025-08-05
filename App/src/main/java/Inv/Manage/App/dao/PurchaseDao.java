package Inv.Manage.App.dao;

import org.springframework.stereotype.Repository;

import Inv.Manage.App.entity.Purchase;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class PurchaseDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public Purchase createPurchase(Purchase purchase) {
		entityManager.persist(purchase);
		return purchase;
	}
	
	public boolean isInvoiceExist(String invoiceNo) {
		
		//String sql = "select * from t_purchase a where a.prc_invoice = "+invoiceNo;

		String HQL = "FROM Purchase WHERE invoice = :inv";
		Query query = entityManager.createQuery(HQL).setParameter("inv", invoiceNo);
		return !(query.getResultList() == null || query.getResultList().isEmpty());
	}
	
	public Purchase getPurchaseById(int id) {
		
		String HQL = "FROM Purchase WHERE id = :id";
		
		Purchase record = null;
		try {
			record = (Purchase) entityManager.createQuery(HQL)
					.setParameter("id", id).getSingleResult();
		}catch(NoResultException ex){
		}catch(NonUniqueResultException ex) {
		}
		
		return record;
	}

	@Transactional
	public Purchase updatePurchase(Purchase updatedRecord) {
		updatedRecord = entityManager.merge(updatedRecord);
		return updatedRecord;
	}
	
}
