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

import budgettracker.common.util.BTListUtils;
import budgettracker.domain.AllotmentEntity;
import budgettracker.domain.UserEntity;
import budgettracker.service.UserService;
import budgettracker.web.editor.DateEditor;
import budgettracker.web.editor.DoubleEditor;
import budgettracker.web.editor.IntegerEditor;
import budgettracker.web.form.AllotmentForm;

@Controller
@RequestMapping(value = "/allotments.htm")
public class AllotmentsController {

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
		
		AllotmentForm allotmentForm = new AllotmentForm();
		allotmentForm.setItemList(currentUser.getAllotmentList());
		model.addAttribute(allotmentForm);
		
		//returns the view name
		return "allotments";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("allotmentForm") AllotmentForm allotmentForm, 
			BindingResult result, HttpSession session, SessionStatus status) {
		logger.info("processSubmit() invoked");
		
		UserEntity currentUser = (UserEntity) session.getAttribute("currentUser");
		if (currentUser == null) {
			return "redirect:login.htm";
		}
		
		List<AllotmentEntity> allotmentList = allotmentForm.getItemList();

		currentUser.setAllotmentList((List<AllotmentEntity>) BTListUtils.filter(allotmentList));
		session.setAttribute("currentUser", userService.updateUserWithFlush(currentUser));
		
		//returns the view name
		return "redirect:allotments.htm";
	}
	
	@InitBinder
	public void initBinderAll(WebDataBinder dataBinder, HttpSession session) {
		logger.debug("initBinderAll() invoked");
		dataBinder.registerCustomEditor(Integer.class, new IntegerEditor());
		dataBinder.registerCustomEditor(Double.class, new DoubleEditor());
		dataBinder.registerCustomEditor(Date.class, new DateEditor());
	}
}
