package budgettracker.dao;

import java.util.List;

import budgettracker.common.dao.GenericDao;
import budgettracker.domain.PartyEntity;
import budgettracker.domain.UserEntity;


public interface UserDao extends GenericDao<UserEntity, Long>{
	/**
	 * Queries database for user name availability
	 * 
	 * @param userName
	 * @return true if available
	 */
	public boolean checkAvailable(String userName);
	
	/**
	 * Queries user by username
	 * 
	 * @param userName
	 * @return UserEntity
	 */
	public UserEntity loadUserByUserName(String userName);

	public List<PartyEntity> loadParties();

	public UserEntity updateWithRefresh(UserEntity userEntity);
}
