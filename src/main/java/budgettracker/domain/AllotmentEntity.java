package budgettracker.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ALLTMENT")
@PrimaryKeyJoinColumn(name="ID")
public class AllotmentEntity extends OwnerEntity {
	private static final long serialVersionUID = 5634033508109958081L;
	
	@Column(name="CURAMT")
	private Double currentAmount;
	
	@Column(name="TGTAMT")
	private Double targetAmount;

	@Column(name="TGTDATE")
	@Temporal(TemporalType.DATE)
	private Date targetDate;

	public Double getCurrentAmount() {
		return currentAmount;
	}
	
	public void setCurrentAmount(Double currentAmount) {
		this.currentAmount = currentAmount;
	}

	public Double getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(Double targetAmount) {
		this.targetAmount = targetAmount;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	
	@Override
	public boolean hasData() {
		return (super.hasData() ||
				(getCurrentAmount() != null) ||
				(getTargetAmount() != null) ||
				(getTargetDate() != null));
	}
	
}
