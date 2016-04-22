package budgettracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import budgettracker.common.domain.BaseEntity;

@Entity
@Table(name="DOUTFLOW")
public class DailyOutflowEntity extends BaseEntity {

	private static final long serialVersionUID = -5975172912197544686L;
	
	@ManyToOne
	@JoinColumn(name="USERID", insertable=false, 
			updatable=false, nullable=false)
	private UserEntity user;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="CMMENT")
	private String comment;
	
	@Column(name="UNITAMT")
	private Double unitAmount;
	
	@Column(name="TTLUNITS")
	private Integer totalUnits;
	
	@Override
	public boolean hasData() {
		return ((getTitle() != null && getTitle() != "") ||
				(getComment() != null && getComment() != "") ||
				(getTotalUnits() != null) ||
				(getUnitAmount() != null)
				);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

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

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public UserEntity getUser() {
		return user;
	}
	
	
}
