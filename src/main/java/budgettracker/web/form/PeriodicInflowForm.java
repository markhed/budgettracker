package budgettracker.web.form;

import java.util.List;

import budgettracker.domain.PeriodicInflowEntity;

public class PeriodicInflowForm {

	private List<PeriodicInflowEntity> periodicInflowList;
	private boolean current;
	
	public void setPeriodicInflowList(List<PeriodicInflowEntity> periodicInflowList) {
		this.periodicInflowList = periodicInflowList;
	}
	
	public List<PeriodicInflowEntity> getPeriodicInflowList() {
		return periodicInflowList;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}

	public boolean isCurrent() {
		return current;
	}

	
}
