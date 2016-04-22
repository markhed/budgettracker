package budgettracker.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import budgettracker.common.util.BTListUtils;
import budgettracker.domain.PartyEntity;
import budgettracker.domain.UserEntity;
import budgettracker.service.UserService;
import budgettracker.web.form.PartyForm;

@Controller
@RequestMapping(value="/parties.htm")
public class PartiesController {

	private final Logger logger = Logger.getLogger(getClass());	
	
	@Autowired 
	UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String loadForm(ModelMap model, HttpSession session) {
		logger.info("loadForm() invoked");
		
		UserEntity currentUser = (UserEntity) session.getAttribute("currentUser");
		if (currentUser == null) {
			return "redirect:login.htm";
		}
		
		PartyForm partyForm = new PartyForm();
		partyForm.setItemList(currentUser.getPartyList());
		model.addAttribute(partyForm);
		
		//returns the view name
		return "parties";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method=RequestMethod.POST)
	public String processSubmit(@ModelAttribute("partyForm") PartyForm partyForm, 
			BindingResult result, HttpSession session, SessionStatus status) {
		logger.info("processSubmit() invoked");
		
		UserEntity currentUser = (UserEntity) session.getAttribute("currentUser");
		if (currentUser == null) {
			return "redirect:login.htm";
		}
		
		List<PartyEntity> partyList = partyForm.getItemList();

		currentUser.setPartyList((List<PartyEntity>) BTListUtils.filter(partyList));
		session.setAttribute("currentUser", userService.updateUserWithFlush(currentUser));
		
		//returns the view name
		return "redirect:parties.htm";
	}
}