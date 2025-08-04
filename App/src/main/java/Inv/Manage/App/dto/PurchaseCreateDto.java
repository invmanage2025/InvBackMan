package Inv.Manage.App.dto;

import java.time.LocalDateTime;

public class PurchaseCreateDto {
	
	private String invoice;
	private String remarks;
	private LocalDateTime startDate;
	private String createdBy;
	
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Override
	public String toString() {
		return "PurchaseCreateDto [invoice=" + invoice + ", remarks=" + remarks + ", startDate=" + startDate
				+ ", createdBy=" + createdBy + "]";
	}
	
	
	
	
	
	
}
