package budgettracker.web.form;

import java.util.List;

import budgettracker.domain.PartyEntity;

public class PartyForm {
	private List<PartyEntity> itemList;

	public List<PartyEntity> getItemList() {
		return itemList;
	}

	public void setItemList(List<PartyEntity> itemList) {
		this.itemList = itemList;
	}
}
