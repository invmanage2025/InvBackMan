package Inv.Manage.App.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Inv.Manage.App.dao.PurchaseDao;
import Inv.Manage.App.dto.PurchaseCreateDto;
import Inv.Manage.App.dto.PurchaseDto;
import Inv.Manage.App.dto.PurchaseUpdateDto;
import Inv.Manage.App.entity.Purchase;
import Inv.Manage.App.utility.InvConstants;
import Inv.Manage.App.utility.InvMessage;

@Service
public class PurchaseService {

	@Autowired
	PurchaseDao dao;
	
	public void getAllPurchase() {
		//DAO Call
	}
	
	public PurchaseDto createPurchase(PurchaseCreateDto purchaseCreateDto) {
		
		if(purchaseCreateDto != null) {
			
			//Create hibernate entity - id is not set, updated by not set
			
			Purchase purchase = new Purchase();
			
			purchase.setInvoice(purchaseCreateDto.getInvoice());
			purchase.setRemarks(purchaseCreateDto.getRemarks());
			purchase.setEffStartDate(purchaseCreateDto.getStartDate());
			purchase.setEffEndDate(InvConstants.HIGH_DATE);
			purchase.setDeletedFlag(false);
			purchase.setCreatedBy(purchaseCreateDto.getCreatedBy());
			
			dao.createPurchase(purchase);
			
			PurchaseDto createdInstance = new PurchaseDto(purchase);
			return createdInstance;
		}
		
		return null;
	}

	public boolean isInvoiceExist(String invoiceNo) {
		return dao.isInvoiceExist(invoiceNo);
	}

	public PurchaseDto updatePurchase(PurchaseUpdateDto updateDto) {
		if(updateDto != null) {
			
			Purchase existingRecord = dao.getPurchaseById(updateDto.getId());
			
			if(existingRecord != null) {
				
				PurchaseDto existingDto = new PurchaseDto(existingRecord);
				boolean isUpdateRequired = false;
				
				if(updateDto.getUpdatedInvoice() != null && 
						!updateDto.getUpdatedInvoice().equals(existingRecord.getInvoice())) {
					
					if(this.isInvoiceExist(updateDto.getUpdatedInvoice())) {
						existingDto.addMessage(new InvMessage(InvMessage.Type.ERROR, "Invoice already exists."));
						return existingDto;
					}
					
					existingRecord.setInvoice(updateDto.getUpdatedInvoice());
					isUpdateRequired = true;
				}
				if(updateDto.getUpdatedRemarks() != null && 
						!updateDto.getUpdatedRemarks().equals(existingRecord.getRemarks())) {
					
					existingRecord.setRemarks(updateDto.getUpdatedRemarks());
					isUpdateRequired = true;
				}
				
				if(isUpdateRequired) {
					
					existingRecord.setUpdatedBy(updateDto.getUpdatedUser());
					Purchase updatedRecord = dao.updatePurchase(existingRecord);
					
					PurchaseDto updatedDto = new PurchaseDto(updatedRecord);
					return updatedDto;
					
				}else{
					existingDto.addMessage(new InvMessage(InvMessage.Type.INFO, "Nothing to update."));
					return existingDto;
				}
			}
		}
		return null;
	}
	
}
