package budgettracker.domain.stub;

import java.util.ArrayList;

import budgettracker.domain.BudgetAccountEntity;
import budgettracker.domain.datatype.Status;

public class BudgetAccountStub extends BaseStub<BudgetAccountEntity>{
	
	public BudgetAccountStub() {
		stubs = new ArrayList<BudgetAccountEntity>();
		BudgetAccountEntity account;
		
		account = new BudgetAccountEntity();
		account.setId(new Long(10001));
		account.setTitle("budgetAccount1 title");
		account.setAccountNumber("10002");
		account.setCurrentAmount(new Double(10003));
		account.setStatus(Status.Active);
		stubs.add(account);

		account = new BudgetAccountEntity();
		account.setId(new Long(20001));
		account.setTitle("budgetAccount2 title");
		account.setAccountNumber("20002");
		account.setCurrentAmount(new Double(20003));
		account.setStatus(Status.Active);
		
		stubs.add(account);
	}
}
