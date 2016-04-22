package budgettracker.service;

import budgettracker.domain.UserEntity;
import budgettracker.web.form.LoginForm;

/**
 * Provides service methods to work with user data and entity.
 * 
 * @author Markhed
 */
public interface UserService {

	/**
	 * Create user - persist to database
	 * 
	 * @param userEntity
	 * @return true if success
	 */
	public boolean createUser(UserEntity userEntity);
	public boolean updateUser(UserEntity userEntity);
	public UserEntity updateUserWithFlush(UserEntity userEntity);
	public UserEntity updateUserWithRefresh(UserEntity userEntity);
	public boolean deleteUser(UserEntity userEntity);
	public UserEntity loadUserByLoginForm(LoginForm loginForm); //temporary
}