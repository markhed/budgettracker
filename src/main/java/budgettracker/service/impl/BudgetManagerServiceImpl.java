package budgettracker.service.impl;

import java.util.List;

import budgettracker.dao.UserDao;
import budgettracker.domain.PartyEntity;
import budgettracker.domain.PeriodicInflowEntity;
import budgettracker.domain.UserEntity;
import budgettracker.service.BudgetManagerService;
import budgettracker.web.form.LoginForm;

public class BudgetManagerServiceImpl implements BudgetManagerService {
	private UserDao userDao; 
	
	@Override
	public UserEntity loadUserByLoginForm(LoginForm loginForm) {
		UserEntity userEntity = userDao.loadUserByUserName(loginForm.getUserName());
		if (userEntity != null && userEntity.getPassword().equals(loginForm.getPassword())) {
			return userEntity;
		}
		else
			return null;
	}

	@Override
	public List<PartyEntity> loadUserParties(UserEntity user) {
		List<PartyEntity> parties = userDao.loadParties();
		
		return parties;
	}

	@Override
	public List<PeriodicInflowEntity> loadUserPeriodicInflows(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


}
