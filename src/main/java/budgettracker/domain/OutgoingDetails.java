package budgettracker.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Outflow-specific details
 * @author Markhed
 *
 */
@Embeddable
public class OutgoingDetails implements Serializable {
	
	private static final long serialVersionUID = -2613353534437086018L;

	@Column(name="UNITAMT")
	private Double unitAmount;
	
	@Column(name="TTLUNIT")
	private Integer totalUnits;
	
	@Column(name="OUTUNIT")
	private Integer outstUnits;

	public Double getUnitAmount() {
		return unitAmount;
	}

	public void setUnitAmount(Double unitAmount) {
		this.unitAmount = unitAmount;
	}

	public Integer getTotalUnits() {
		return totalUnits;
	}

	public void setTotalUnits(Integer totalUnits) {
		this.totalUnits = totalUnits;
	}

	public Integer getOutstUnits() {
		return outstUnits;
	}

	public void setOutstUnits(Integer outstUnits) {
		this.outstUnits = outstUnits;
	}
	
	
}
