package budgettracker.web.form;

import java.util.List;

import budgettracker.domain.PeriodicOutflowEntity;

public class PeriodicOutflowForm {

	private List<PeriodicOutflowEntity> periodicOutflowList;
	private boolean current;
	
	public List<PeriodicOutflowEntity> getPeriodicOutflowList() {
		return periodicOutflowList;
	}
	
	public void setPeriodicOutflowList(
			List<PeriodicOutflowEntity> periodicOutflowList) {
		this.periodicOutflowList = periodicOutflowList;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}

	public boolean isCurrent() {
		return current;
	}
	
	
	
	
}
