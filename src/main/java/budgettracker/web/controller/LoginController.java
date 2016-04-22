package budgettracker.web.controller;

import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import budgettracker.domain.UserEntity;
import budgettracker.service.UserService;
import budgettracker.web.form.LoginForm;

@Controller
@RequestMapping(value = "/login.htm")
public class LoginController {
	
	protected final Logger logger = Logger.getLogger(getClass());	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String loadForm(ModelMap model, HttpSession session) {
		logger.info("loadForm() invoked");
		
		if (session.getAttribute("currentUser") != null) {
			return "redirect:main.htm";
		}
		
		model.addAttribute("loginForm", new LoginForm());
		
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("loginForm") LoginForm loginForm, HttpSession session) {
		logger.info("processSubmit() invoked");
		UserEntity userEntity = userService.loadUserByLoginForm(loginForm);

		if (userEntity != null) {
			session.setAttribute("currentUser", userEntity);
			return "redirect:main.htm";
		}
		
		return "login";
	}
}
