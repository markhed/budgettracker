package budgettracker.web.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import budgettracker.common.util.BTListUtils;
import budgettracker.domain.DailyOutflowEntity;
import budgettracker.domain.UserEntity;
import budgettracker.service.UserService;
import budgettracker.web.editor.DoubleEditor;
import budgettracker.web.editor.IntegerEditor;
import budgettracker.web.form.DailyOutflowForm;

@Controller
@RequestMapping(value = "/dailyexpenses.htm")
public class DailyExpensesController {

	private final Logger logger = Logger.getLogger(getClass());	
	
	@Autowired 
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String loadForm(ModelMap model, HttpSession session) {
		logger.info("loadForm() invoked");
		
		UserEntity currentUser = (UserEntity) session.getAttribute("currentUser");
		if (currentUser == null) {
			return "redirect:login.htm";
		}
		
		DailyOutflowForm dailyOutflowForm = new DailyOutflowForm();
		dailyOutflowForm.setItemList(currentUser.getDailyOutflowList());
		model.addAttribute(dailyOutflowForm);
		
		return "dailyexpenses";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("dailyOutflowForm") DailyOutflowForm dailyOutflowForm, 
			BindingResult result, HttpSession session, SessionStatus status) {
		logger.info("processSubmit() invoked");
		
		UserEntity currentUser = (UserEntity) session.getAttribute("currentUser");
		if (currentUser == null) {
			return "redirect:login.htm";
		}
		
		List<DailyOutflowEntity> dailyOutflowList = dailyOutflowForm.getItemList();
		
		currentUser.setDailyOutflowList((List<DailyOutflowEntity>) BTListUtils.filter(dailyOutflowList));
		session.setAttribute("currentUser", userService.updateUserWithFlush(currentUser));

		return "redirect:dailyexpenses.htm";
	}
	
	@InitBinder
	public void initBinderAll(WebDataBinder dataBinder, HttpSession session) {
		logger.debug("initBinderAll() invoked");
		dataBinder.registerCustomEditor(Integer.class, new IntegerEditor());
		dataBinder.registerCustomEditor(Double.class, new DoubleEditor());
	}
}