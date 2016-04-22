package budgettracker.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;


import budgettracker.domain.UserEntity;
import budgettracker.service.BudgetManagerService;
import budgettracker.service.UserService;

@SuppressWarnings("deprecation")
public class SignUpController extends SimpleFormController {

	static Logger logger = Logger.getLogger(SignUpController.class);
	
	private UserService userService;
	@SuppressWarnings("unused")
	private BudgetManagerService budgetManagerService;

	public SignUpController()	{
		logger.info("SignUpController() invoked");
		setCommandClass(UserEntity.class);
		setCommandName("UserForm");
		//use SignUpForm
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setBudgetManagerService(BudgetManagerService budgetManagerService) {
		this.budgetManagerService = budgetManagerService;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
		throws Exception {
		logger.info("formBackingObject() invoked");
		
		UserEntity userEntity = new UserEntity();
		return userEntity;
	}

	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		logger.info("onSubmit() invoked");
		
		UserEntity userEntity = (UserEntity) command;
		userService.createUser(userEntity);
		
		return new ModelAndView("redirect:main.htm");
	}
}
