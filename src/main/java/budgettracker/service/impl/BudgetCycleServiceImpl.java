package budgettracker.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import budgettracker.dao.BudgetCycleDao;
import budgettracker.domain.BudgetCycleEntity;
import budgettracker.domain.UserEntity;
import budgettracker.service.BudgetCycleService;

public class BudgetCycleServiceImpl implements BudgetCycleService {
	protected final Logger logger = Logger.getLogger(getClass());
	
	private BudgetCycleDao budgetCycleDao;
	
	public void setBudgetCycleDao(BudgetCycleDao budgetCycleDao) {
		this.budgetCycleDao = budgetCycleDao;
	}

	public BudgetCycleDao getBudgetCycleDao() {
		return budgetCycleDao;
	}

	@Override
	public boolean saveBudgetCycle(BudgetCycleEntity budgetCycleEntity) {
		try {
			if (budgetCycleEntity.getId() == null) {
				budgetCycleDao.save(budgetCycleEntity);
			}
			else {
				budgetCycleDao.update(budgetCycleEntity);
			}
		} catch (Exception e){
			logger.error("saveBudgetCycle() FAIL, exception is " + e.getMessage());
			return false;
		}
		
		logger.info("saveBudgetCycle() SUCCESS");
		return true;
	}

	@Override
	public boolean deleteBudgetCycle(BudgetCycleEntity budgetCycleEntity) {
		try {
			budgetCycleDao.delete(budgetCycleEntity);
		} catch (Exception e){
			logger.error("deleteBudgetCycle() FAIL, exception is " + e.getMessage());
			return false;
		}
		
		logger.info("deleteBudgetCycle() SUCCESS");
		return true;
	}

	@Override
	public BudgetCycleEntity loadBudgetCycle(BudgetCycleEntity budgetCycle) {
		try {
			return budgetCycleDao.findByIdEager(budgetCycle.getId());
		} catch (Exception e){
			logger.error("loadBudgetCycle() FAIL, exception is " + e.getMessage());
			return null;
		}
	}
	
	public BudgetCycleEntity loadBudgetCycleByID(Long id) {
		try {
			return budgetCycleDao.findByIdEager(id);
		} catch (Exception e){
			logger.error("loadBudgetCycle() FAIL, exception is " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<BudgetCycleEntity> loadAllBudgetCycles() {
		try {
			return budgetCycleDao.findAll();
		} catch (Exception e){
			logger.error("loadAllBudgetCycles() FAIL, exception is " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<BudgetCycleEntity> loadBudgetCyclesByUser(UserEntity currentUser) {
		try {
			return budgetCycleDao.findAllByUser(currentUser);
		} catch (Exception e){
			logger.error("loadBudgetCyclesByUser() FAIL, exception is " + e.getMessage());
			return null;
		}
	}
	
	@Override
	public List<BudgetCycleEntity> loadBudgetCyclesByUserWithEager(UserEntity currentUser) {
		try {
			return budgetCycleDao.findAllByUserWithEager(currentUser);
		} catch (Exception e){
			logger.error("loadBudgetCyclesByUser() FAIL, exception is " + e.getMessage());
			return null;
		}
	}

	@Override
	public BudgetCycleEntity updateCycleWithFlush(BudgetCycleEntity budgetCycleEntity) {
		BudgetCycleEntity budgetCycle = null;
		try {
			budgetCycle = budgetCycleDao.update(budgetCycleEntity); // this function refreshes the entity as well - temp
			budgetCycleDao.flush();
		} catch (Exception e){
			return budgetCycle;
		}
		
		return budgetCycle;
	}
	
	
	

}
