package budgettracker.domain.stub;

import java.util.ArrayList;
import budgettracker.domain.BudgetCycleEntity;

public class BudgetCycleStub extends BaseStub<BudgetCycleEntity>{
	
	public BudgetCycleStub() {
		stubs = new ArrayList<BudgetCycleEntity>();
		BudgetCycleEntity budgetCycle;
		
		budgetCycle = new BudgetCycleEntity();	
		stubs.add(budgetCycle);
		
		budgetCycle = new BudgetCycleEntity();
		stubs.add(budgetCycle);
	}
}
