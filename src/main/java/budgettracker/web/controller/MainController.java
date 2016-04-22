package budgettracker.web.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import budgettracker.domain.UserEntity;
import budgettracker.service.UserService;

@Controller
public class MainController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	public UserService userService;
	
	@RequestMapping(value = "/main.htm")
	public String loadMainPage(ModelMap model, HttpSession session) {
		UserEntity currentUser = (UserEntity) session.getAttribute("currentUser");
        
		if (currentUser != null) {
	        model.addAttribute("currentUser", currentUser);       
	        return "main";
		} else {
			//userService flush
		}
		
		return "redirect:login.htm";
	}
	
	@RequestMapping(value = "/logout.htm")
	public String logOut(HttpSession session) {
		session.removeAttribute("currentUser");
		
		return "redirect:login.htm";
	}
}