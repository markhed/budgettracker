package budgettracker.web.form;

import java.util.List;

import budgettracker.domain.BudgetCycleEntity;

public class BudgetCycleForm {
	private List<BudgetCycleEntity> budgetCycleList;

	public List<BudgetCycleEntity> getBudgetCycleList() {
		return budgetCycleList;
	}

	public void setBudgetCycleList(List<BudgetCycleEntity> budgetCycleList) {
		this.budgetCycleList = budgetCycleList;
	}
}
