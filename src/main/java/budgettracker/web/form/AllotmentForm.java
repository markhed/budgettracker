package budgettracker.web.form;

import java.util.List;

import budgettracker.domain.AllotmentEntity;

public class AllotmentForm {
	private List<AllotmentEntity> itemList;

	public void setItemList(List<AllotmentEntity> itemList) {
		this.itemList = itemList;
	}

	public List<AllotmentEntity> getItemList() {
		return itemList;
	}
}
