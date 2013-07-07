package th.co.geek;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import th.co.geek.model.Login;
import th.co.geek.model.Register;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute("loginForm")@Valid Login login, BindingResult result) {
		System.out.println(login);
		
		if (result.hasErrors()) {
			
			return new ModelAndView("loginForm");
		}
		return new ModelAndView("loginSuccess","login",login);
	}
	
	@RequestMapping(value = "/login",  method = RequestMethod.GET)
	public String login() {
		return "loginForm";
	}
	
	@ModelAttribute("loginForm")
	public Login loginForm() {
		Login login = new Login();
		 
		return login;
	}
	
	
	
	
	

	
	
}
