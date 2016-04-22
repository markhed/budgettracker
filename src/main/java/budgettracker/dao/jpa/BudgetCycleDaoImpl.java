package budgettracker.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.util.Assert;

import budgettracker.common.dao.jpa.GenericDaoImpl;
import budgettracker.dao.BudgetCycleDao;
import budgettracker.domain.BudgetCycleEntity;
import budgettracker.domain.BudgetManagerEntity;
import budgettracker.domain.UserEntity;

public class BudgetCycleDaoImpl extends GenericDaoImpl<BudgetCycleEntity, Long> implements BudgetCycleDao {

	public BudgetCycleDaoImpl() {
		super(BudgetCycleEntity.class);
	}

	public List<BudgetCycleEntity> findAllByManager(BudgetManagerEntity manager) {
		throw new NotYetImplementedException();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BudgetCycleEntity> findAllByUser(UserEntity user) {
		Assert.notNull(user);
		List<BudgetCycleEntity> budgetCycles = new ArrayList<BudgetCycleEntity>();
		
		Query query = getEntityManager().createQuery("select x from " + getPersistentClass().getSimpleName()
				+ " x where x.user = :user").setParameter("user", user);
		
		try {
			budgetCycles = (List<BudgetCycleEntity>) query.getResultList();
		} catch(NoResultException e) {
			//do nothing
		}
		
		return budgetCycles;
	}

	@Override
	public BudgetCycleEntity findByIdEager(Long id) {
		BudgetCycleEntity budgetCycle = null;
		try {
			budgetCycle = findById(id);
			budgetCycle.getInflowList().size();
			budgetCycle.getOutflowList().size(); //temp solution for eager loading
		} catch (NoResultException e) {
			//temp
		}
		return budgetCycle;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BudgetCycleEntity> findAllByUserWithEager(UserEntity user) {
		Assert.notNull(user);
		List<BudgetCycleEntity> budgetCycles = new ArrayList<BudgetCycleEntity>();
		
		Query query = getEntityManager().createQuery("select x from " + getPersistentClass().getSimpleName()
				+ " x where x.user = :user").setParameter("user", user);
		
		try {
			budgetCycles = (List<BudgetCycleEntity>) query.getResultList();
			for (BudgetCycleEntity budgetCycle : budgetCycles) {
				budgetCycle.getInflowList().size();
				budgetCycle.getOutflowList().size(); //temp solution for eager loading
			}
		} catch(NoResultException e) {
			//do nothing
		}
		
		return budgetCycles;
	}
}
