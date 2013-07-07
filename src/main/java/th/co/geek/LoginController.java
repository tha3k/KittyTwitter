package th.co.geek;

import javax.servlet.http.HttpSession;
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
import th.co.geek.constant.Constant;
import th.co.geek.model.Login;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute("loginForm")@Valid Login login, BindingResult result, HttpSession session) {
		System.out.println(login);
		
		if (result.hasErrors()) {
			return new ModelAndView("loginForm");
		}
		
		UserLoginAction loginAction = new UserLoginAction();
		
		// check login
		try {
			System.out.println("check authenticate");
			UserProfile userProfile = loginAction.authenticate(login.getUserName(), login.getPassword());
			session.setAttribute(Constant.UserProfileSession, userProfile);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//not found user.
			result.addError(new ObjectError("username", "Username Not Found. "));
			logger.error("not found user ");
			return new ModelAndView("loginForm");
		}
		System.out.println("loginSuccess");
		return new ModelAndView("timelineForm","timelineForm",login);
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
	
	/*@ModelAttribute("posts")
	public List<Post> getTimeline() {
		get post 
	}*/
	
	
	
	

	
	
}
