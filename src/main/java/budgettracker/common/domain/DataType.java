package budgettracker.common.domain;

import org.hibernate.usertype.UserType;

public abstract class DataType implements UserType {
	protected String code;
	

	public DataType(String code) {
		this.code = code;
	}

	public DataType() {
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
