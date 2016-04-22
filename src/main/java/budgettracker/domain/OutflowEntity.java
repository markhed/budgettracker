package budgettracker.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity 
@Table(name="OUTFLOW")
@Inheritance(strategy = InheritanceType.JOINED)
public class OutflowEntity extends CycleCashFlowEntity {

	private static final long serialVersionUID = 5607429042656004729L;
	
	@Embedded
	protected OutgoingDetails outgoingDetails = new OutgoingDetails();
	
	@Override
	public boolean hasData() {
		return ((super.hasData()) ||
				(getOutgoingDetails().getUnitAmount() != null && getOutgoingDetails().getUnitAmount() != 0) || 
				(getOutgoingDetails().getUnitAmount() != null && getOutgoingDetails().getTotalUnits() != 0) || 
				(getOutgoingDetails().getUnitAmount() != null && getOutgoingDetails().getOutstUnits() != 0));
	}
	
	public OutgoingDetails getOutgoingDetails() {
		return outgoingDetails;
	}

	public void setOutgoingDetails(OutgoingDetails outgoingDetails) {
		this.outgoingDetails = outgoingDetails;
	}

}
