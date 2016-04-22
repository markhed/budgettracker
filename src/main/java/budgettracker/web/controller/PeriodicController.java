package budgettracker.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import budgettracker.common.util.BTListUtils;
import budgettracker.domain.OwnerEntity;
import budgettracker.domain.PeriodicInflowEntity;
import budgettracker.domain.PeriodicOutflowEntity;
import budgettracker.domain.UserEntity;
import budgettracker.domain.datatype.BudgetType;
import budgettracker.domain.datatype.BudgetTypeUserType;
import budgettracker.service.UserService;
import budgettracker.web.editor.BudgetTypeEditor;
import budgettracker.web.editor.DateEditor;
import budgettracker.web.editor.DoubleEditor;
import budgettracker.web.editor.IntegerEditor;
import budgettracker.web.editor.OwnerEditor;
import budgettracker.web.form.PeriodicInflowForm;
import budgettracker.web.form.PeriodicOutflowForm;

@Controller 
@RequestMapping("/periodic.htm")
public class PeriodicController {
	
	Logger logger = Logger.getLogger(getClass());
	
	@Autowired 
	public UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String loadForm(HttpSession session, Model model) {
		logger.info("loadForm() invoked");
		UserEntity currentUser = (UserEntity) session.getAttribute("currentUser");
		
		if (currentUser != null) {
			PeriodicInflowForm periodicInflowForm = new PeriodicInflowForm();
			periodicInflowForm.setPeriodicInflowList(currentUser.getPeriodicInflowList());
			model.addAttribute(periodicInflowForm);
			
			PeriodicOutflowForm periodicOutflowForm = new PeriodicOutflowForm();
			periodicOutflowForm.setPeriodicOutflowList(currentUser.getPeriodicOutflowList());
			model.addAttribute(periodicOutflowForm);
			
			model.addAttribute("ownerList", currentUser.getOwnerList());
			//JSONArray array = new JSONArray(ownerList);
			//model.addAttribute("ownerArray", array);
			session.setAttribute("ownerList", currentUser.getOwnerList());
			
			//returns the view name
			return "periodic";
		}
		
		return "redirect:login.htm";
	}

	
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmitInflow(@ModelAttribute("periodicInflowForm") PeriodicInflowForm periodicInflowForm, 
								@ModelAttribute("periodicOutflowForm") PeriodicOutflowForm periodicOutflowForm,
								HttpSession session) {
		logger.info("processSubmit() invoked");
		
		UserEntity currentUser = (UserEntity) session.getAttribute("currentUser");
		if (currentUser == null) {
			return "redirect:login.htm";
		}
		
		List<PeriodicInflowEntity> periodicInflowList = periodicInflowForm.getPeriodicInflowList();
		List<PeriodicOutflowEntity> periodicOutflowList = periodicOutflowForm.getPeriodicOutflowList();
		
		//this is necessary because the forms are submitted separately via ajax and so at least one list is always empty
		if (periodicInflowList != null) {
			currentUser.setPeriodicInflowList((List<PeriodicInflowEntity>) BTListUtils.filter(periodicInflowList));
		//} else if (currentUser.getPeriodicInflows() != null && !currentUser.getPeriodicInflows().isEmpty()) { //this means that all of the items were deleted
		//	currentUser.setPeriodicInflows(new ArrayList<PeriodicInflowEntity>());
		}
		
		if (periodicOutflowList != null) {
			currentUser.setPeriodicOutflowList((List<PeriodicOutflowEntity>) BTListUtils.filter(periodicOutflowList));
		//} else if (currentUser.getPeriodicOutflows() != null && !currentUser.getPeriodicOutflows().isEmpty()) { //this means that all of the items were deleted
		//	currentUser.setPeriodicOutflows(new ArrayList<PeriodicOutflowEntity>());
		}
		
		session.setAttribute("currentUser", userService.updateUserWithFlush(currentUser));
		
		//to re-render the page and include IDs of newly stored items
		return "redirect:periodic";
	}
	
	@ModelAttribute("budgetTypeList")
	public List<BudgetType> getBudgetTypeList() {
		logger.debug("getBudgetTypeList() invoked");
		return BudgetTypeUserType.getList();
	}

	@InitBinder
	public void initBinderAll(WebDataBinder dataBinder, HttpSession session) {
		logger.debug("initBinderAll() invoked");
		dataBinder.registerCustomEditor(BudgetType.class, new BudgetTypeEditor());
		dataBinder.registerCustomEditor(Integer.class, new IntegerEditor());
		dataBinder.registerCustomEditor(Double.class, new DoubleEditor());
		dataBinder.registerCustomEditor(Date.class, new DateEditor());
		
		@SuppressWarnings("unchecked")
		List<OwnerEntity> owners = (List<OwnerEntity>) session.getAttribute("ownerList");
		dataBinder.registerCustomEditor(OwnerEntity.class, new OwnerEditor(owners));
	}
}
