package budgettracker.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import budgettracker.common.domain.BaseEntity;

@Entity
@Table (name = "BGTMNGR")
public class BudgetManagerEntity extends BaseEntity {

	private static final long serialVersionUID = -9181273912793976206L;
	
	@Column (name = "CASHHAND")
	private int cashOnHand;
	@Transient
	private List<AllotmentEntity> allotments;
	@Transient
	private List<BudgetAccountEntity> accounts;
	@Transient
	private List<BudgetCycleEntity> cycles;
	@Transient
	private List<CreditCardEntity> creditCards;
	@Transient
	private List<DailyOutflowEntity> dailyOutflows;
	@Transient
	private List<PartyEntity> parties;
	@Transient
	private List<PeriodicInflowEntity> periodicInflows;
	@Transient
	private List<PeriodicOutflowEntity> periodicOutflows;
	
	public List<OwnerEntity> getOwners() {
		List<OwnerEntity> owners = new ArrayList<OwnerEntity>();
		owners.addAll(getCreditCards());
		owners.addAll(getAllotments());
		owners.addAll(getParties());
		
		return owners;
	}

	public int getCashOnHand() {
		return cashOnHand;
	}

	public void setCashOnHand(int cashOnHand) {
		this.cashOnHand = cashOnHand;
	}

	public List<AllotmentEntity> getAllotments() {
		return allotments;
	}

	public void setAllotments(List<AllotmentEntity> allotments) {
		this.allotments = allotments;
	}

	public List<BudgetAccountEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BudgetAccountEntity> accounts) {
		this.accounts = accounts;
	}

	public List<CreditCardEntity> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCardEntity> creditCards) {
		this.creditCards = creditCards;
	}

	public List<DailyOutflowEntity> getDailyOutflows() {
		return dailyOutflows;
	}

	public void setDailyOutflows(List<DailyOutflowEntity> dailyOutflows) {
		this.dailyOutflows = dailyOutflows;
	}

	public List<PartyEntity> getParties() {
		return parties;
	}

	public void setParties(List<PartyEntity> parties) {
		this.parties = parties;
	}

	public List<PeriodicInflowEntity> getPeriodicInflows() {
		return periodicInflows;
	}

	public void setPeriodicInflows(List<PeriodicInflowEntity> periodicInflows) {
		this.periodicInflows = periodicInflows;
	}

	public List<PeriodicOutflowEntity> getPeriodicOutflows() {
		return periodicOutflows;
	}

	public void setPeriodicOutflows(List<PeriodicOutflowEntity> periodicOutflows) {
		this.periodicOutflows = periodicOutflows;
	}

	public List<BudgetCycleEntity> getCycles() {
		return cycles;
	}

	public void setCycles(List<BudgetCycleEntity> cycles) {
		this.cycles = cycles;
	}

	@Override
	public boolean hasData() {
		return (getId() != null);
	}
}
