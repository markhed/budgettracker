package budgettracker.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity 
@Table(name="INFLOW")
@Inheritance(strategy=InheritanceType.JOINED)
public class InflowEntity extends CycleCashFlowEntity {

	private static final long serialVersionUID = -8951532899224998924L;

	@Embedded
	protected IncomingDetails incomingDetails = new IncomingDetails();
	
	@Override
	public boolean hasData() {
		return ((super.hasData()) || 
				(getIncomingDetails().getReceivedAmount() != null && getIncomingDetails().getReceivedAmount() != 0));
	}

	public IncomingDetails getIncomingDetails() {
		return incomingDetails;
	}

	public void setIncomingDetails(IncomingDetails incomingDetails) {
		this.incomingDetails = incomingDetails;
	}
}
