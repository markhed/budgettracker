package budgettracker.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.cfg.NotYetImplementedException;

import budgettracker.common.domain.BaseEntity;

/** 
 * Entity to hold application user data
 * @author Markhed
 *
 */
@Entity
@Table(name="USR")
public class UserEntity extends BaseEntity{
	private static final long serialVersionUID = -8789920463809744548L;
	
	@Column(name="FNAME")
	private String firstName;
	
	@Column(name="LNAME")
	private String lastName;
	
	@Column(name="ACCLOGIN")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
    @OneToMany(cascade={CascadeType.ALL}, orphanRemoval=true, 
    		fetch=FetchType.LAZY, targetEntity=BudgetAccountEntity.class)
    @JoinColumn(name="USERID", nullable=false, insertable=false, 
    		updatable=false)
	private List<BudgetAccountEntity> accountList;
    
    @OneToMany(cascade={CascadeType.ALL}, orphanRemoval=true, 
    		fetch=FetchType.LAZY, targetEntity=AllotmentEntity.class)
    @JoinColumn(name="USERID", nullable=false, insertable=false, 
    		updatable=false)
	private List<AllotmentEntity> allotmentList;
    
    @OneToMany(cascade={CascadeType.ALL}, orphanRemoval=true, 
    		fetch=FetchType.LAZY, targetEntity=CreditCardEntity.class)
    @JoinColumn(name="USERID", nullable=false, insertable=false, 
    		updatable=false)
	private List<CreditCardEntity> creditCardList;
	
    @OneToMany(cascade={CascadeType.ALL}, orphanRemoval=true, 
    		fetch=FetchType.LAZY, targetEntity=DailyOutflowEntity.class)
    @JoinColumn(name="USERID", nullable=false, insertable=false, 
    		updatable=false)
	private List<DailyOutflowEntity> dailyOutflowList;
    

    @OneToMany(cascade={CascadeType.ALL}, orphanRemoval=true, 
    		fetch=FetchType.LAZY, targetEntity=PartyEntity.class)
    //specifies that this class is the owner of the bidirectional relationship
    //if not specified, a join table USR_OWNER is being created
    @JoinColumn(name="USERID", nullable=false, insertable=false, 
    		updatable=false)
	private List<PartyEntity> partyList;
    
    @OneToMany(cascade={CascadeType.ALL}, orphanRemoval=true, 
    		fetch=FetchType.LAZY, targetEntity=PeriodicInflowEntity.class)
    @JoinColumn(name="USERID", nullable=false, insertable=false, 
    		updatable=false)
	private List<PeriodicInflowEntity> periodicInflowList;
    
    @OneToMany(cascade={CascadeType.ALL}, orphanRemoval=true, 
    		fetch=FetchType.LAZY, targetEntity=PeriodicOutflowEntity.class)
    @JoinColumn(name="USERID", nullable=false, insertable=false, 
    		updatable=false)
	private List<PeriodicOutflowEntity> periodicOutflowList;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		//PasswordEncoder crypto = new Md5PasswordEncoder();
		//this.password = crypto.encodePassword(password, null);
		this.password = password;
	}
	
	@Override
	public boolean hasData() {
		throw new NotYetImplementedException();
	}

	public List<PartyEntity> getPartyList() {
		return partyList;
	}

	public void setPartyList(List<PartyEntity> partyList) {
		this.partyList = partyList;
	}

	public List<CreditCardEntity> getCreditCardList() {
		return creditCardList;
	}

	public void setCreditCardList(List<CreditCardEntity> creditCardList) {
		this.creditCardList = creditCardList;
	}

	public List<PeriodicInflowEntity> getPeriodicInflowList() {
		return periodicInflowList;
	}

	public void setPeriodicInflowList(List<PeriodicInflowEntity> periodicInflowList) {
		this.periodicInflowList = periodicInflowList;
	}

	public List<PeriodicOutflowEntity> getPeriodicOutflowList() {
		return periodicOutflowList;
	}

	public void setPeriodicOutflowList(List<PeriodicOutflowEntity> periodicOutflowList) {
		this.periodicOutflowList = periodicOutflowList;
	}
	
	public List<OwnerEntity> getOwnerList() {
		List<OwnerEntity> list = new ArrayList<OwnerEntity>();
		list.addAll(getAllotmentList());
		list.addAll(getCreditCardList());
		list.addAll(getPartyList());
		
		return list;
	}

	public void setAllotmentList(List<AllotmentEntity> allotmentList) {
		this.allotmentList = allotmentList;
	}

	public List<AllotmentEntity> getAllotmentList() {
		return allotmentList;
	}

	public void setAccountList(List<BudgetAccountEntity> accountList) {
		this.accountList = accountList;
	}

	public List<BudgetAccountEntity> getAccountList() {
		return accountList;
	}

	public void setDailyOutflowList(List<DailyOutflowEntity> dailyOutflowList) {
		this.dailyOutflowList = dailyOutflowList;
	}

	public List<DailyOutflowEntity> getDailyOutflowList() {
		return dailyOutflowList;
	}

}