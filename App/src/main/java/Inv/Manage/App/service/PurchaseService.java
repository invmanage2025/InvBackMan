package Inv.Manage.App.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Inv.Manage.App.dao.PurchaseDao;
import Inv.Manage.App.dto.PurchaseCreateDto;
import Inv.Manage.App.entity.Purchase;
import Inv.Manage.App.utility.InvConstants;

@Service
public class PurchaseService {

	@Autowired
	PurchaseDao dao;
	
	public void getAllPurchase() {
		//DAO Call
	}
	
	public void createPurchase(PurchaseCreateDto purchaseDto) {
		if(purchaseDto != null) {
			
			//Create hibernate entity - id is not set, updated by not set
			
			Purchase purchase = new Purchase();
			
			purchase.setInvoice(purchaseDto.getInvoice());
			purchase.setRemarks(purchaseDto.getRemarks());
			purchase.setEffStartDate(purchaseDto.getStartDate());
			purchase.setEffEndDate(InvConstants.HIGH_DATE);
			purchase.setDeletedFlag(false);
			purchase.setCreatedBy(purchaseDto.getCreatedBy());
			
			dao.createPurchase(purchase);
		}
	}
	
}
