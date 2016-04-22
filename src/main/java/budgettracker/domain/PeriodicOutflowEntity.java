package budgettracker.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PRDOUTFLOW")
@PrimaryKeyJoinColumn(name="ID") //ID of Outflow class
public class PeriodicOutflowEntity extends PeriodicCashFlowEntity {

	private static final long serialVersionUID = -1966807270194515188L;

	@Embedded
	protected OutgoingDetails outgoingDetails = new OutgoingDetails();
	
	@Override
	public boolean hasData() {
		return ((super.hasData()) ||
				(getOutgoingDetails().getUnitAmount() != null) || 
				(getOutgoingDetails().getUnitAmount() != null) || 
				(getOutgoingDetails().getUnitAmount() != null));
	}
	
	public OutgoingDetails getOutgoingDetails() {
		return outgoingDetails;
	}

	public void setOutgoingDetails(OutgoingDetails outgoingDetails) {
		this.outgoingDetails = outgoingDetails;
	}
}
