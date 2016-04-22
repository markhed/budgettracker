package budgettracker.dao.jpa;

import budgettracker.common.dao.jpa.GenericDaoImpl;
import budgettracker.dao.BudgetManagerDao;
import budgettracker.domain.BudgetManagerEntity;

public class BudgetManagerDaoImpl extends GenericDaoImpl<BudgetManagerEntity, Long> implements BudgetManagerDao {

	public BudgetManagerDaoImpl() {
		super(BudgetManagerEntity.class);
	}
}
