package budgettracker.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;
import budgettracker.common.domain.BaseEntity;
import budgettracker.domain.datatype.FlowType;
import budgettracker.domain.datatype.Status;

@MappedSuperclass
public abstract class CycleCashFlowEntity extends BaseEntity implements CashFlow {
	
	private static final long serialVersionUID = 6402324458372568766L;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BGTCYCLEID", nullable=false, insertable=false,
    		updatable=false)
	protected BudgetCycleEntity budgetCycle;
	
	@Embedded
	protected CashFlowDetails cashFlowDetails = new CashFlowDetails();
	
	@Column(name="CRTNDATE", updatable=false, nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date creationDate;
	
	@Column(name="STATUS")
	@Type(type="budgettracker.domain.datatype.StatusUserType")
	protected Status status;
	
	@Column(name="FTYPE")
	@Type(type="budgettracker.domain.datatype.FlowTypeUserType")
	protected FlowType flowType;

	@Override
	public boolean hasData() {
		return ((getCashFlowDetails().getComment() != null && getCashFlowDetails().getComment() != "") ||
				(getCashFlowDetails().getTitle() != null && getCashFlowDetails().getTitle() != "") ||
				(getCashFlowDetails().getOutstAmount() != null));
	}
	
	@PrePersist
	public void setCreationDate() {
		if (this.creationDate == null) {
			this.creationDate = new Date();
		}
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public BudgetCycleEntity getBudgetCycle() {
		return budgetCycle;
	}

	public void setBudgetCycle(BudgetCycleEntity budgetCycle) {
		this.budgetCycle = budgetCycle;
	}

	public CashFlowDetails getCashFlowDetails() {
		return cashFlowDetails;
	}

	public void setCashFlowDetails(CashFlowDetails cashFlowDetails) {
		this.cashFlowDetails = cashFlowDetails;
	}

	public FlowType getFlowType() {
		return flowType;
	}

	public void setFlowType(FlowType flowType) {
		this.flowType = flowType;
	}


	
	
	
}
