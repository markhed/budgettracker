package budgettracker.common.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * an abstract base entity class which all domain classes need to extend
 * @author Markhed
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 568379222048217476L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * checks if entity has meaningful data
	 * @return boolean
	 */
	public abstract boolean hasData();
	
}
