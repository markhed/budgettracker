package budgettracker.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Inflow-specific details
 * @author Markhed
 *
 */
@Embeddable
public class IncomingDetails implements Serializable {
	
	private static final long serialVersionUID = -4189381728095234203L;
	
	@Column(name="RECAMT")
	private Double receivedAmount;

	public Double getReceivedAmount() {
		return receivedAmount;
	}

	public void setReceivedAmount(Double receivedAmount) {
		this.receivedAmount = receivedAmount;
	}
	
	
}
