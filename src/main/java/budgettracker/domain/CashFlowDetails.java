package budgettracker.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import budgettracker.domain.datatype.BudgetType;
import budgettracker.domain.datatype.FlowType;

/**
 * General cash flow details
 * @author Markhed
 *
 */
@Embeddable
public class CashFlowDetails implements Serializable {

	private static final long serialVersionUID = -2171574230911204052L;

	@Column(name="TITLE") 
	protected String title;
	
	@Column(name="OUTAMT")
	protected Double outstAmount;
	
	@Column(name="CMMENT")
	protected String comment;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="OWNERID")
	protected OwnerEntity owner;
	
	@Column(name="BGTTYPE")
	@Type(type="budgettracker.domain.datatype.BudgetTypeUserType")
	protected BudgetType budgetType;
	
	@Column(name="FLOWTYPE")
	@Type(type="budgettracker.domain.datatype.FlowTypeUserType")
	protected FlowType flowType;

	public OwnerEntity getOwner() {
		return owner;
	}

	public void setOwner(OwnerEntity owner) {
		this.owner = owner;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getOutstAmount() {
		return outstAmount;
	}

	public void setOutstAmount(Double outstAmount) {
		this.outstAmount = outstAmount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public BudgetType getBudgetType() {
		return budgetType;
	}

	public void setBudgetType(BudgetType budgetType) {
		this.budgetType = budgetType;
	}

	public FlowType getFlowType() {
		return flowType;
	}

	public void setFlowType(FlowType flowType) {
		this.flowType = flowType;
	}
}
