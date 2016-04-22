package budgettracker.service;

import java.util.List;

import budgettracker.domain.BudgetCycleEntity;
import budgettracker.domain.UserEntity;

public interface BudgetCycleService {

	public boolean saveBudgetCycle(BudgetCycleEntity budgetCycleEntity);
	public boolean deleteBudgetCycle(BudgetCycleEntity budgetCycleEntity);
	public List<BudgetCycleEntity> loadBudgetCyclesByUser(UserEntity currentUser);
	public BudgetCycleEntity loadBudgetCycle(BudgetCycleEntity budgetCycle);
	public BudgetCycleEntity loadBudgetCycleByID(Long id);
	public List<BudgetCycleEntity> loadAllBudgetCycles();
	public BudgetCycleEntity updateCycleWithFlush(BudgetCycleEntity budgetCycle);
	public List<BudgetCycleEntity> loadBudgetCyclesByUserWithEager(UserEntity currentUser);
}
