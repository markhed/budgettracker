package budgettracker.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import budgettracker.common.domain.BaseEntity;
import budgettracker.domain.datatype.Status;

@Entity
@Table(name="BGTCYCLE")
public class BudgetCycleEntity extends BaseEntity {

	private static final long serialVersionUID = 5345566489709892109L;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USERID", referencedColumnName="ID")
	protected UserEntity user;
	
    @OneToMany(cascade={CascadeType.ALL}, orphanRemoval=true, 
    		fetch=FetchType.LAZY, targetEntity=InflowEntity.class)
    @JoinColumn(name="BGTCYCLEID", nullable=false, insertable=false,
    		updatable=false)
	protected List<InflowEntity> inflowList;
	
    @OneToMany(cascade={CascadeType.ALL}, orphanRemoval=true, 
    		fetch=FetchType.LAZY, targetEntity=OutflowEntity.class)
    @JoinColumn(name="BGTCYCLEID", nullable=false, insertable=false,
    		updatable=false)
	protected List<OutflowEntity> outflowList;
	
	@Column(name="STRTDATE")
	@Temporal(TemporalType.DATE)
	protected Date startDate; //maybe Calendar is better
	
	@Column(name="ENDDATE")
	@Temporal(TemporalType.DATE)
	protected Date endDate;
	
	@Column(name="STATUS")
	@Type(type="budgettracker.domain.datatype.StatusUserType")
	protected Status status;
	
	@Transient
	protected Double dispensableAmount;
	
	@Transient
	protected Double totalDailyOutflow;
	
	@Transient
	protected Double totalRemainingOutflow;
	
	@Transient
	protected Double totalIncurredOutflow;
	
	@Transient
	protected Double totalActualInflow;
	
	@Override
	public boolean hasData() {
		return getStatus() != null;
		//return (getStartDate() != null || getEndDate() != null);
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<InflowEntity> getInflowList() {
		return inflowList;
	}

	public void setInflowList(List<InflowEntity> inflowList) {
		this.inflowList = inflowList;
	}

	public List<OutflowEntity> getOutflowList() {
		return outflowList;
	}

	public void setOutflowList(List<OutflowEntity> outflowList) {
		this.outflowList = outflowList;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Double getDispensableAmount() {
		return dispensableAmount;
	}

	public void setDispensableAmount(Double dispensableAmount) {
		this.dispensableAmount = dispensableAmount;
	}

	public Double getTotalDailyOutflow() {
		return totalDailyOutflow;
	}

	public void setTotalDailyOutflow(Double totalDailyOutflow) {
		this.totalDailyOutflow = totalDailyOutflow;
	}

	public Double getTotalRemainingOutflow() {
		return totalRemainingOutflow;
	}

	public void setTotalRemainingOutflow(Double totalRemainingOutflow) {
		this.totalRemainingOutflow = totalRemainingOutflow;
	}

	public Double getTotalIncurredOutflow() {
		return totalIncurredOutflow;
	}

	public void setTotalIncurredOutflow(Double totalIncurredOutflow) {
		this.totalIncurredOutflow = totalIncurredOutflow;
	}

	public Double getTotalActualInflow() {
		return totalActualInflow;
	}

	public void setTotalActualInflow(Double totalActualInflow) {
		this.totalActualInflow = totalActualInflow;
	}
	
}
