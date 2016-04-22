package budgettracker.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@SecondaryTable(name="CCARD", pkJoinColumns={
//    @PrimaryKeyJoinColumn(name="ID", referencedColumnName="ID") //for name, ID of creditCard, and ref is ID of owner
//})
//@DiscriminatorValue("C")
@Entity
@Table(name="CCARD")
@PrimaryKeyJoinColumn(name="ID")
public class CreditCardEntity extends OwnerEntity{

	private static final long serialVersionUID = -9219649279452583333L;
	
	@Column(name="BANKNM")
	protected String bankName;
	
	@Column(name="CUTDATE")
	@Temporal(TemporalType.DATE)
	protected Date cutoffDate;
	
	@Column(name="DUEDATE")
	@Temporal(TemporalType.DATE)
	protected Date dueDate;
	
	@Column(name="ACCNTNM")
	protected String accountNumber;
	
	@Column(name="CLIMIT")
	protected Double creditLimit;

	@Override
	public boolean hasData() {
		return ((super.hasData()) ||
				(getBankName() != null && getBankName() != "") ||
				(getAccountNumber() != null) ||
				(getCreditLimit() != null) ||
				(getCutoffDate() != null) ||
				(getDueDate() != null));
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Date getCutoffDate() {
		return cutoffDate;
	}

	public void setCutoffDate(Date cutoffDate) {
		this.cutoffDate = cutoffDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}
}
