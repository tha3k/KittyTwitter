package th.co.geek;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import th.co.geek.action.UserLoginAction;
import th.co.geek.bean.UserProfile;
import th.co.geek.model.Login;

@Controller
public class TimelineController {
	private static final Logger logger = LoggerFactory.getLogger(TimelineController.class);
	
	
	@RequestMapping(value="/timeline", method = RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute("timelineForm")@Valid Login login, BindingResult result) {
		System.out.println(login);
		
		if (result.hasErrors()) {
			return new ModelAndView("timelineForm");
		}
		
		
		// check login
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//not found user.
			return new ModelAndView("timelineForm");
		}
		
		
		return new ModelAndView("loginSuccess","login",login);
	}
	
	@RequestMapping(value = "/timeline",  method = RequestMethod.GET)
	public String timeline() {
		return "timelineForm";
	}
	
	@ModelAttribute("timelineForm")
	public Login loginForm() {
		Login login = new Login();
		 
		return login;
	}
	
	
	
	
	

	
	
}
