package budgettracker.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PRDINFLOW")
@PrimaryKeyJoinColumn(name="ID") //ID of inflow
//@AssociationOverride(name="budgetCycle", joinColumns={@JoinColumn(name="BGTCYCLEID", nullable=true)}) //wont work since it requires to override a concrete table
public class PeriodicInflowEntity extends PeriodicCashFlowEntity {
	
	private static final long serialVersionUID = 3446919276799609973L;

	@Embedded
	protected IncomingDetails incomingDetails = new IncomingDetails();
	
	@Override
	public boolean hasData() {
		return ((super.hasData()) || 
				(getIncomingDetails().getReceivedAmount() != null));
	}
	
	public IncomingDetails getIncomingDetails() {
		return incomingDetails;
	}

	public void setIncomingDetails(IncomingDetails incomingDetails) {
		this.incomingDetails = incomingDetails;
	}


}
