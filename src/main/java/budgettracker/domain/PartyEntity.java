package budgettracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * A person/company that is/can be an owner of inflows or outflows
 * @author Markhed
 *
 */
@Entity
@Table(name="PARTY")
@PrimaryKeyJoinColumn(name="ID") //ID of owner, used if Owner is an Entity with Inheritance.Joined
public class PartyEntity extends OwnerEntity {

	private static final long serialVersionUID = 6165347334869993059L;
	
	@Column(name="FNAME") 
	protected String firstName;
	
	@Column(name="LNAME") 
	protected String lastName;
	
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

	@Override
	public boolean hasData() {
		return ((super.hasData()) ||
				(getFirstName() != null && getFirstName() != "") ||
				(getLastName() != null && getLastName() != ""));
	}
}
