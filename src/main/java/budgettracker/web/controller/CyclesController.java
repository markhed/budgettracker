package budgettracker.web.controller;

import java.util.Date;
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

import budgettracker.domain.BudgetCycleEntity;
import budgettracker.domain.UserEntity;
import budgettracker.domain.datatype.Status;
import budgettracker.domain.datatype.StatusUserType;
import budgettracker.service.BudgetCycleService;
import budgettracker.web.editor.DateEditor;
import budgettracker.web.editor.StatusEditor;
import budgettracker.web.form.BudgetCycleForm;

@Controller
@RequestMapping(value="/cycles.htm")
public class CyclesController {

	private final Logger logger = Logger.getLogger(getClass());	
	@Autowired 
	BudgetCycleService budgetCycleService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String loadForm(ModelMap model, HttpSession session) {
		logger.info("loadForm() invoked");
		
		UserEntity currentUser = (UserEntity) session.getAttribute("currentUser");
		
		if (currentUser != null) {
			BudgetCycleForm budgetCycleForm = new BudgetCycleForm();
			List<BudgetCycleEntity> budgetCycleList = budgetCycleService.loadBudgetCyclesByUserWithEager(currentUser);
			budgetCycleForm.setBudgetCycleList(budgetCycleList);
			model.addAttribute(budgetCycleForm);
			
			//returns the view name
			return "cycles";
		}
		
		return "redirect:login.htm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String processSubmit(@ModelAttribute("budgetCycleForm") BudgetCycleForm budgetCycleForm, 
			BindingResult result, HttpSession session, SessionStatus status) {
		logger.info("processSubmit() invoked");
		
		List<BudgetCycleEntity> budgetCycleList = budgetCycleForm.getBudgetCycleList();
		UserEntity currentUser = (UserEntity) session.getAttribute("currentUser");
		
		for (BudgetCycleEntity budgetCycleEntity : budgetCycleList) {
			if (budgetCycleEntity.hasData()) {
				budgetCycleEntity.setUser(currentUser);
				budgetCycleService.saveBudgetCycle(budgetCycleEntity);
				
			} else if (budgetCycleEntity.getId() != null) {
				budgetCycleService.deleteBudgetCycle(budgetCycleEntity);
			}
		}
		
		//clear the command object from the session
		status.setComplete(); 
		
		//returns the view name
		return "redirect:cycles.htm";
	}
	
	@ModelAttribute("statusList")
	public List<Status> getStatusList() {
		logger.debug("getStatusList() invoked");
		return StatusUserType.getList(BudgetCycleEntity.class);
	}
	
	@InitBinder
	public void initBinderAll(WebDataBinder dataBinder, HttpSession session) {
		logger.debug("initBinderAll() invoked");
		dataBinder.registerCustomEditor(Status.class, new StatusEditor());
		dataBinder.registerCustomEditor(Date.class, new DateEditor());
	}
}
