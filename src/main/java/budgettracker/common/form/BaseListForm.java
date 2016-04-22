package budgettracker.common.form;

import java.util.ArrayList;
import java.util.List;

public class BaseListForm<T> {
	private List<T> itemList = new ArrayList<T>();

	public void setItemList(List<T> itemList) {
		this.itemList = itemList;
	}

	public List<T> getItemList() {
		return itemList;
	}
}
