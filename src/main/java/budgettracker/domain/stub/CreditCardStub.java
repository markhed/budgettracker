package budgettracker.domain.stub;

import java.util.ArrayList;
import java.util.Date;

import budgettracker.domain.CreditCardEntity;

public class CreditCardStub extends BaseStub<CreditCardEntity>{
	
	public CreditCardStub() {
		stubs = new ArrayList<CreditCardEntity>();
		CreditCardEntity creditCard;
		
		creditCard = new CreditCardEntity();
		creditCard.setId(new Long(10001));
		creditCard.setAccountNumber("10002");
		creditCard.setBankName("creditcard1 bank");
		creditCard.setCreditLimit(new Double(10003));
		creditCard.setCutoffDate(new Date());
		creditCard.setDueDate(new Date());
		creditCard.setTitle("creditcard1 title");
		creditCard.setComment("creditcard1 comment");
		stubs.add(creditCard);
		
		creditCard = new CreditCardEntity();
		creditCard.setId(new Long(20001));
		creditCard.setAccountNumber("20002");
		creditCard.setBankName("creditcard2 bank");
		creditCard.setCreditLimit(new Double(20003));
		creditCard.setCutoffDate(new Date());
		creditCard.setDueDate(new Date());
		creditCard.setTitle("creditcard2 title");
		creditCard.setComment("creditcard2 comment");
		stubs.add(creditCard);
	}
}
