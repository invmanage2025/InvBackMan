package Inv.Manage.App.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Inv.Manage.App.entity.Purchase;
import Inv.Manage.App.utility.InvMessage;

public class PurchaseDto {

    private int id;
    private String invoice;
    private String remarks;
    private LocalDateTime effStartDate;
    private LocalDateTime effEndDate;
    private boolean deletedFlag;
    private String createdBy;
    private String updatedBy;
    
    private List<InvMessage> messageList;

	public List<InvMessage> getMessageList() {
		return messageList;
	}
	public void setMessageList(List<InvMessage> messageList) {
		this.messageList = messageList;
	}
	
	public void addMessage(InvMessage message) {
		if(this.messageList == null) {
			this.messageList = new ArrayList<>();
		}
		this.messageList.add(message);
	}
	public boolean isErrorOccurred() {
		return this.messageList != null && !this.messageList.isEmpty();
	}

	// Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
 // Getters and Setters
    public LocalDateTime getEffStartDate() {
        return effStartDate;
    }

    public void setEffStartDate(LocalDateTime effStartDate) {
        this.effStartDate = effStartDate;
    }

    public LocalDateTime getEffEndDate() {
        return effEndDate;
    }

    public void setEffEndDate(LocalDateTime effEndDate) {
        this.effEndDate = effEndDate;
    }

    public boolean getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(boolean deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    // Constructors
    public PurchaseDto() {
    }

	public PurchaseDto(int id, String invoice, String remarks, LocalDateTime effStartDate, LocalDateTime effEndDate,
			boolean deletedFlag, String createdBy, String updatedBy) {
		super();
		this.id = id;
		this.invoice = invoice;
		this.remarks = remarks;
		this.effStartDate = effStartDate;
		this.effEndDate = effEndDate;
		this.deletedFlag = deletedFlag;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}
	
	public PurchaseDto(Purchase purchase) {
		
		this.id = purchase.getId();
		this.invoice = purchase.getInvoice();
		this.remarks = purchase.getRemarks();
		this.effStartDate = purchase.getEffStartDate();
		this.effEndDate = purchase.getEffEndDate();
		this.deletedFlag = purchase.getDeletedFlag();
		this.createdBy = purchase.getCreatedBy();
		this.updatedBy = purchase.getUpdatedBy();
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", invoice=" + invoice + ", remarks=" + remarks + ", effStartDate=" + effStartDate
				+ ", effEndDate=" + effEndDate + ", deletedFlag=" + deletedFlag + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + "]";
	}

    

}
