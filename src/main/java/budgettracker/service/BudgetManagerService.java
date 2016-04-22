package budgettracker.service;

import java.util.List;

import budgettracker.domain.PartyEntity;
import budgettracker.domain.PeriodicInflowEntity;
import budgettracker.domain.UserEntity;
import budgettracker.web.form.LoginForm;

public interface BudgetManagerService {
	//load user
	public UserEntity loadUserByLoginForm(LoginForm loginForm);
	//load parties
	public List<PartyEntity> loadUserParties(UserEntity user);
	//load periodic inflow
	public List<PeriodicInflowEntity> loadUserPeriodicInflows(UserEntity user);
}
