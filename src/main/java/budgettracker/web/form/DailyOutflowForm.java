package budgettracker.web.form;

import java.util.List;

import budgettracker.domain.DailyOutflowEntity;

public class DailyOutflowForm {
	private List<DailyOutflowEntity> itemList;

	public void setItemList(List<DailyOutflowEntity> itemList) {
		this.itemList = itemList;
	}

	public List<DailyOutflowEntity> getItemList() {
		return itemList;
	}
	
}
