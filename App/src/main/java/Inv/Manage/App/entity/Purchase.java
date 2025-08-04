package Inv.Manage.App.entity;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prc_seq")
    @SequenceGenerator(name = "prc_seq", sequenceName = "prc_seq", allocationSize = 1)
    @Column(name = "prc_id")
    private int id;

    @Column(name = "prc_invoice")
    private String invoice;

    @Column(name = "prc_remarks")
    private String remarks;
    
    @Column(name = "eff_start_date")
    private LocalDateTime effStartDate;

    @Column(name = "eff_end_date")
    private LocalDateTime effEndDate;

    @Column(name = "deleted_flag")
    private boolean deletedFlag;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

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
    public Purchase() {
    }

	public Purchase(int id, String invoice, String remarks, LocalDateTime effStartDate, LocalDateTime effEndDate,
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

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", invoice=" + invoice + ", remarks=" + remarks + ", effStartDate=" + effStartDate
				+ ", effEndDate=" + effEndDate + ", deletedFlag=" + deletedFlag + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + "]";
	}

    

}
