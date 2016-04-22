package budgettracker.dao.jpa;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.util.Assert;

import budgettracker.common.dao.jpa.GenericDaoImpl;
import budgettracker.dao.UserDao;
import budgettracker.domain.PartyEntity;
import budgettracker.domain.UserEntity;



/**
 * JPA implementation of UserDao 
 * 
 */
public class UserDaoImpl extends GenericDaoImpl<UserEntity, Long> implements UserDao {

	public UserDaoImpl() {
		super(UserEntity.class);
	}

	/**
	 * Queries database for user name availability
	 * 
	 * @param userName
	 * @return true if available
	 */
	public boolean checkAvailable(String userName) {
		Assert.notNull(userName);
		
		Query query = getEntityManager()
			.createQuery("select count(*) from " + getPersistentClass().getSimpleName() 
					+ " u where u.userName = :userName").setParameter("userName", userName);
		
		Long count = (Long) query.getSingleResult();
		
		return count < 1;
	}

	/**
	 * Queries user by username
	 * 
	 * @param userName
	 * @return User
	 */
	public UserEntity loadUserByUserName(String userName) {
		Assert.notNull(userName);
		
		UserEntity user = null;
		
		Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
				+ " u where u.userName = :userName").setParameter("userName", userName);
		
		try {
			user = (UserEntity) query.getSingleResult();
			user.getAllotmentList().size();  //temporary solution in eager-loading attributes
			user.getAccountList().size();
			user.getDailyOutflowList().size();
			user.getPartyList().size();
			user.getCreditCardList().size();
			user.getPeriodicInflowList().size();
			user.getPeriodicOutflowList().size();
		} catch(NoResultException e) {
			//do nothing
		}
		
		return user;
	}

	@Override
	public List<PartyEntity> loadParties() {
		return null;
	}

	@Override
	public UserEntity updateWithRefresh(UserEntity user) {
		user = getEntityManager().merge(user);
		//getEntityManager().refresh(getEntityManager().find(user.getClass(), user.getId())); //not working
		//user.getPartyList().size(); //temporary solution in eager-loading attributes
		//user.getPeriodicInflowList().size();
		//user.getPeriodicOutflowList().size();
		return user;
	}

}
