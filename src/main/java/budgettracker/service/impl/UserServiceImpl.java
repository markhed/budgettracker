package budgettracker.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import budgettracker.dao.UserDao;
import budgettracker.domain.UserEntity;
import budgettracker.service.UserService;
import budgettracker.web.form.LoginForm;


/**
 * Service providing service methods to work with user data and entity.
 * 
 */
public class UserServiceImpl implements UserService, UserDetailsService {
	/* this attribute is set by spring (through the setter method) with 
	 * an instantiated object (as UserJpaDao) as configured
	 * in applicationContext.xml (see bean declaration)
	 */
	private UserDao userDao; 
	
	/**
	 * Create user - persist to database
	 * 
	 * @param userEntity
	 * @return true if success
	 */
	public boolean createUser(UserEntity userEntity) {
		if (!userDao.checkAvailable(userEntity.getUserName())) {
			FacesMessage message = constructErrorMessage(String.format("User name '%s' is not available", userEntity.getUserName()), null);
			getFacesContext().addMessage(null, message);
			
			return false;
		}
		try {
			userDao.save(userEntity);
		} catch (Exception e){
			FacesMessage message = constructFatalMessage(e.getMessage(), null);
			getFacesContext().addMessage(null, message);
			System.out.println("createUser failed, exception is " + e.getMessage());
			return false;
		}
		
		return true;
	}

	public boolean updateUser(UserEntity userEntity) {
		try {
			userDao.update(userEntity);
		} catch (Exception e){
			FacesMessage message = constructFatalMessage(e.getMessage(), null);
			getFacesContext().addMessage(null, message);
			return false;
		}
		
		return true;
	}
	
	public UserEntity updateUserWithFlush(UserEntity userEntity) {
		UserEntity user = null;
		try {
			user = userDao.updateWithRefresh(userEntity); // this function refreshes the entity as well - temp
			userDao.flush();
		} catch (Exception e){
			FacesMessage message = constructFatalMessage(e.getMessage(), null);
			getFacesContext().addMessage(null, message);
			return user;
		}
		
		return user;
	}
	
	/**
	 * Construct userDetails required by Spring Security
	 */
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserEntity user = userDao.loadUserByUserName(userName);
		
		if (user == null) {
			throw new UsernameNotFoundException(String.format("No such user with name provided '%s'", userName));
		}
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		User userDetails = new User(user.getUserName(), user.getPassword(), authorities);
		
		return userDetails;
	}

	public UserEntity getLoggedUser() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		UserEntity user = userDao.loadUserByUserName(userName);
		
		return user;
	}
	
	protected FacesMessage constructErrorMessage (String message, String detail){
		return new FacesMessage(FacesMessage.SEVERITY_ERROR, message, detail);
	}
	
	protected FacesMessage constructInfoMessage (String message, String detail){
		return new FacesMessage(FacesMessage.SEVERITY_INFO, message, detail);
	}
	
	protected FacesMessage constructFatalMessage (String message, String detail){
		return new FacesMessage(FacesMessage.SEVERITY_FATAL, message, detail);
	}
	
	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean deleteUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		return false;
	}

	//@Override
	public UserEntity loadUserByLoginForm(LoginForm loginForm) {
		UserEntity userEntity = userDao.loadUserByUserName(loginForm.getUserName());
		if (userEntity != null && userEntity.getPassword().equals(loginForm.getPassword())) {
			return userEntity;
		}
		else
			return null;
	}

	@Override
	public UserEntity updateUserWithRefresh(UserEntity userEntity) {
		UserEntity user = null;
		try {
			user = userDao.updateWithRefresh(userEntity);
		} catch (Exception e){
			FacesMessage message = constructFatalMessage(e.getMessage(), null);
			getFacesContext().addMessage(null, message);
			return user;
		}
		
		return user;
	}
}
