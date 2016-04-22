package budgettracker.domain;

import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import budgettracker.common.domain.BaseEntity;

@MappedSuperclass
public abstract class PeriodicCashFlowEntity extends BaseEntity implements CashFlow, Periodic{

	private static final long serialVersionUID = -8842236039024856340L;
	
	@ManyToOne
	@JoinColumn(name="USERID", insertable=false, 
			updatable=false, nullable=false)
	protected UserEntity user;

	@Embedded
	protected PeriodicDetails periodicDetails = new PeriodicDetails();
	
	@Embedded
	protected CashFlowDetails cashFlowDetails = new CashFlowDetails();
	
	@Override
	public boolean hasData() {
		return ((getPeriodicDetails().getStartDate() != null) || 
				(getPeriodicDetails().getSpecificDay() != null) ||
				(getPeriodicDetails().getSpecificDate() != null) || 
				(getCashFlowDetails().getTitle() != null && getCashFlowDetails().getTitle() != "") ||
				(getPeriodicDetails().getPeriod() != null && getPeriodicDetails().getPeriod() != "") ||
				(getCashFlowDetails().getComment() != null && getCashFlowDetails().getComment() != "") ||
				(getCashFlowDetails().getOutstAmount() != null));
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public PeriodicDetails getPeriodicDetails() {
		return periodicDetails;
	}

	public void setPeriodicDetails(PeriodicDetails periodicDetails) {
		this.periodicDetails = periodicDetails;
	}

	public CashFlowDetails getCashFlowDetails() {
		return cashFlowDetails;
	}

	public void setCashFlowDetails(CashFlowDetails cashFlowDetails) {
		this.cashFlowDetails = cashFlowDetails;
	}
	
	
	
}
