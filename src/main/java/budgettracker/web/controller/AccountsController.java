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
import budgettracker.domain.BudgetAccountEntity;
import budgettracker.domain.UserEntity;
import budgettracker.domain.datatype.Status;
import budgettracker.domain.datatype.StatusUserType;
import budgettracker.service.UserService;
import budgettracker.web.editor.DoubleEditor;
import budgettracker.web.editor.StatusEditor;
import budgettracker.web.form.AccountForm;

@Controller
@RequestMapping(value = "/accounts.htm")
public class AccountsController {

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
		
		AccountForm accountForm = new AccountForm();
		accountForm.setItemList(currentUser.getAccountList());
		model.addAttribute(accountForm);
		
		return "accounts";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("accountForm") AccountForm accountForm, 
			BindingResult result, HttpSession session, SessionStatus status) {
		logger.info("processSubmit() invoked");
		
		UserEntity currentUser = (UserEntity) session.getAttribute("currentUser");
		if (currentUser == null) {
			return "redirect:login.htm";
		}
		
		List<BudgetAccountEntity> accountList = accountForm.getItemList();
		
		currentUser.setAccountList((List<BudgetAccountEntity>) BTListUtils.filter(accountList));
		session.setAttribute("currentUser", userService.updateUserWithFlush(currentUser));

		return "redirect:accounts.htm";
	}
	
	@ModelAttribute("statusList")
	public List<Status> getStatusList() {
		logger.debug("getStatusList() invoked");
		return StatusUserType.getList(BudgetAccountEntity.class);
	}
	
	@InitBinder
	public void initBinderAll(WebDataBinder dataBinder, HttpSession session) {
		logger.debug("initBinderAll() invoked");
		dataBinder.registerCustomEditor(Status.class, new StatusEditor());
		dataBinder.registerCustomEditor(Double.class, new DoubleEditor());
	}
}