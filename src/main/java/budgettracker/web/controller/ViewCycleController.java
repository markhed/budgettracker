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
import org.springframework.web.bind.annotation.RequestParam;

import budgettracker.common.util.BTListUtils;
import budgettracker.domain.BudgetCycleEntity;
import budgettracker.domain.InflowEntity;
import budgettracker.domain.OutflowEntity;
import budgettracker.domain.OwnerEntity;
import budgettracker.domain.UserEntity;
import budgettracker.domain.datatype.BudgetType;
import budgettracker.domain.datatype.BudgetTypeUserType;
import budgettracker.domain.datatype.FlowType;
import budgettracker.domain.datatype.FlowTypeUserType;
import budgettracker.domain.datatype.Status;
import budgettracker.domain.datatype.StatusUserType;
import budgettracker.service.BudgetCycleService;
import budgettracker.web.editor.BudgetTypeEditor;
import budgettracker.web.editor.DateEditor;
import budgettracker.web.editor.DoubleEditor;
import budgettracker.web.editor.FlowTypeEditor;
import budgettracker.web.editor.IntegerEditor;
import budgettracker.web.editor.OwnerEditor;
import budgettracker.web.editor.StatusEditor;
import budgettracker.web.form.ViewCycleForm;

@Controller
@RequestMapping(value="/viewcycle.htm")
public class ViewCycleController {
	
	Logger logger = Logger.getLogger(getClass());
	
	@Autowired 
	public BudgetCycleService budgetCycleService;

	@RequestMapping(method=RequestMethod.GET, params={"selectedCycleID"})
	public String loadForm(@RequestParam("selectedCycleID") Long selectedCycleID, HttpSession session, Model model) {
		logger.info("loadForm() invoked");

		UserEntity currentUser = (UserEntity) session.getAttribute("currentUser");
		
		if (currentUser != null) {
			BudgetCycleEntity selectedCycle = budgetCycleService.loadBudgetCycleByID(selectedCycleID);
		
			if (selectedCycle != null) {
				session.setAttribute("selectedCycle", selectedCycle);
				ViewCycleForm viewCycleForm = new ViewCycleForm();
				viewCycleForm.setInflowList(selectedCycle.getInflowList());
				viewCycleForm.setOutflowList(selectedCycle.getOutflowList());
				model.addAttribute(viewCycleForm);
				model.addAttribute("ownerList", currentUser.getOwnerList()); //decide how to implement this (put everything in the session in the main level?)
				session.setAttribute("ownerList", currentUser.getOwnerList());
				
				//returns the view name
				return "viewcycle";
			}
		}
		
		return "redirect:main.htm";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String loadForm() {
		logger.info("loadForm() invoked");

		return "redirect:main.htm";
	}

	
	@SuppressWarnings("unchecked")
	@RequestMapping(method=RequestMethod.POST)
	public String processSubmitInflow(@ModelAttribute("viewCycleForm") ViewCycleForm viewCycleForm,
								HttpSession session) {
		logger.info("processSubmit() invoked");
		
		BudgetCycleEntity selectedCycle = (BudgetCycleEntity) session.getAttribute("selectedCycle");
		if (selectedCycle == null) {
			return "redirect:main.htm";
		}
		
		List<InflowEntity> inflowList = viewCycleForm.getInflowList();
		List<OutflowEntity> outflowList = viewCycleForm.getOutflowList();
		
		if (inflowList != null) {
			selectedCycle.setInflowList((List<InflowEntity>) BTListUtils.filter(inflowList));
		}
		
		if (outflowList != null) {
			selectedCycle.setOutflowList((List<OutflowEntity>) BTListUtils.filter(outflowList));
		}
		
		session.setAttribute("selectedCycle", budgetCycleService.updateCycleWithFlush(selectedCycle));
		
		//to re-render the page and include IDs of newly stored items
		return "redirect:viewcycle";
	}
	
	@ModelAttribute("budgetTypeList")
	public List<BudgetType> getBudgetTypeList() {
		logger.debug("getBudgetTypeList() invoked");
		return BudgetTypeUserType.getList();
	}
	
	@ModelAttribute("flowTypeList")
	public List<FlowType> getFlowTypeList() {
		logger.debug("getFlowTypeList() invoked");
		return FlowTypeUserType.getList();
	}

	@ModelAttribute("inflowStatusList")
	public List<Status> getInflowStatusList() {
		logger.debug("getStatusList() invoked");
		return StatusUserType.getList(InflowEntity.class);
	}
	
	@ModelAttribute("outflowStatusList")
	public List<Status> getOutflowStatusList() {
		logger.debug("getStatusList() invoked");
		return StatusUserType.getList(OutflowEntity.class);
	}
	
	@InitBinder
	public void initBinderAll(WebDataBinder dataBinder, HttpSession session) {
		logger.debug("initBinderAll() invoked");
		dataBinder.registerCustomEditor(BudgetType.class, new BudgetTypeEditor());
		dataBinder.registerCustomEditor(FlowType.class, new FlowTypeEditor());
		dataBinder.registerCustomEditor(Status.class, new StatusEditor());
		dataBinder.registerCustomEditor(Integer.class, new IntegerEditor());
		dataBinder.registerCustomEditor(Double.class, new DoubleEditor());
		dataBinder.registerCustomEditor(Date.class, new DateEditor());
		
		@SuppressWarnings("unchecked")
		List<OwnerEntity> owners = (List<OwnerEntity>) session.getAttribute("ownerList");
		dataBinder.registerCustomEditor(OwnerEntity.class, new OwnerEditor(owners));
	}
}