package budgettracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import budgettracker.common.domain.BaseEntity;
import budgettracker.domain.datatype.Status;

@Entity 
@Table(name="BGTACCNT")
public class BudgetAccountEntity extends BaseEntity {

	private static final long serialVersionUID = -8802020296327186728L;
	
	@ManyToOne
	@JoinColumn(name="USERID", insertable=false, 
			updatable=false, nullable=false)
	protected UserEntity user;
	
	@Column(name="CURAMT") 
	private Double currentAmount;
	
	@Column(name="TITLE") 
	private String title;
	
	@Column(name="ACCNUM") 
	private String accountNumber;
	
	@Column(name="STATUS")
	@Type(type="budgettracker.domain.datatype.StatusUserType")
	private Status status;

	@Override
	public boolean hasData() {
		return (getTitle() != "" ||
				getCurrentAmount() != null ||
				getAccountNumber() != "");
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public Double getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(Double currentAmount) {
		this.currentAmount = currentAmount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
