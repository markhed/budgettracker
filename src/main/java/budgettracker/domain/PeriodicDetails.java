package budgettracker.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class PeriodicDetails implements Serializable {
	
	private static final long serialVersionUID = -7779403839029471789L;

	@Column(name="PERIOD")
	private String period;
	
	@Column(name="STDATE")
	@Temporal(TemporalType.DATE)
	private Date specificDate;
	
	@Column(name="SPDATE")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name="SPDAY")
	private Integer specificDay;
	
	public String getPeriod() {
		return period;
	}
	
	public void setPeriod(String period) {
		this.period = period;
	}
	
	public Date getSpecificDate() {
		return specificDate;
	}
	
	public void setSpecificDate(Date specificDate) {
		this.specificDate = specificDate;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Integer getSpecificDay() {
		return specificDay;
	}
	
	public void setSpecificDay(Integer specificDay) {
		this.specificDay = specificDay;
	}
	
	
}
