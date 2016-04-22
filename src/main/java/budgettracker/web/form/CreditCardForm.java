package budgettracker.web.form;

import java.util.List;

import budgettracker.domain.CreditCardEntity;

public class CreditCardForm {
	private List<CreditCardEntity> itemList;

	public void setItemList(List<CreditCardEntity> itemList) {
		this.itemList = itemList;
	}

	public List<CreditCardEntity> getItemList() {
		return itemList;
	}


	
	
}
