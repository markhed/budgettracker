package budgettracker.dao;

import java.util.List;

import budgettracker.common.dao.GenericDao;
import budgettracker.domain.BudgetCycleEntity;
import budgettracker.domain.UserEntity;

public interface BudgetCycleDao extends GenericDao <BudgetCycleEntity, Long> {

	List<BudgetCycleEntity> findAllByUser(UserEntity user);

	public BudgetCycleEntity findByIdEager(Long id);

	public List<BudgetCycleEntity> findAllByUserWithEager(UserEntity currentUser);

}
