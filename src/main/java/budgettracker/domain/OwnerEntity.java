package budgettracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import budgettracker.common.domain.BaseEntity;

@Entity 
@Table(name="OWNER")
@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorColumn(name="OWNERTYPEID", discriminatorType=DiscriminatorType.CHAR)
public class OwnerEntity extends BaseEntity { //test, revert to abstract

	private static final long serialVersionUID = 4096741465497798413L;
	
	@Column(name="TITLE")
	protected String title;
	
	@Column(name="CMMENT")
	protected String comment;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "USERID", referencedColumnName = "ID")
	//using below makes this bidirectional, with user being the owner.
	//@ManyToOne
    //@JoinColumn(name="USERID", nullable=false, insertable=false, updatable=false)
	@Transient //temporary
	protected UserEntity user;
	
	//@JoinColumn(name="MANAGERID", referencedColumnName="ID")
	//protected BudgetManagerEntity manager;

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
	/*
	public BudgetManagerEntity getManager() {
		return manager;
	}

	public void setManager(BudgetManagerEntity manager) {
		this.manager = manager;
	}
	*/

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public boolean hasData() {
		return ((getComment() != null && getComment() != "") ||
				(getTitle() != null && getTitle() != ""));
	}
}
