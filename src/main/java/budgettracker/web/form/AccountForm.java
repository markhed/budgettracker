package budgettracker.web.form;

import java.util.List;

import budgettracker.domain.BudgetAccountEntity;

public class AccountForm {
	private List<BudgetAccountEntity> itemList;

	public void setItemList(List<BudgetAccountEntity> itemList) {
		this.itemList = itemList;
	}

	public List<BudgetAccountEntity> getItemList() {
		return itemList;
	}
	
	
}
