package Inv.Manage.App.dto;

public class PurchaseUpdateDto {
	
	private int id;
	private String updatedInvoice;
	private String updatedRemarks;
	private String updatedUser;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUpdatedInvoice() {
		return updatedInvoice;
	}
	public void setUpdatedInvoice(String updatedInvoice) {
		this.updatedInvoice = updatedInvoice;
	}
	public String getUpdatedRemarks() {
		return updatedRemarks;
	}
	public void setUpdatedRemarks(String updatedRemarks) {
		this.updatedRemarks = updatedRemarks;
	}
	public String getUpdatedUser() {
		return updatedUser;
	}
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}
	@Override
	public String toString() {
		return "PurchaseUpdateDto [updatedInvoice=" + updatedInvoice + ", updatedRemarks=" + updatedRemarks
				+ ", updatedUser=" + updatedUser + "]";
	}
	
	
	
}
