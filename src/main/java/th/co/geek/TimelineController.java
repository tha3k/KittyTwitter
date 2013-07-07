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
import th.co.geek.dao.UserPostDAO;
import th.co.geek.model.Login;
import th.co.geek.model.Timeline;

@Controller
public class TimelineController {
	private static final Logger logger = LoggerFactory.getLogger(TimelineController.class);
	
	
	@RequestMapping(value="/timeline", method = RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute("timelineForm")@Valid Timeline timeline, BindingResult result, HttpSession httpSession) {
		System.out.println(timeline);
		
		if (result.hasErrors()) {
			return new ModelAndView("timelineForm");
		}
		
		UserPostDAO userPostDAO = UserPostDAO.getInstance();
		
		// check login
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//not found user.
			return new ModelAndView("timelineForm");
		}
		
		
		return new ModelAndView("timelineForm","timeline",timeline);
	}
	
	@RequestMapping(value = "/timeline",  method = RequestMethod.GET)
	public String timeline(HttpSession session) {
		
		return "timelineForm";
	}
	
	@ModelAttribute("timelineForm")
	public Timeline timelineForm(HttpSession session) {
		Timeline timeline = new Timeline();
		 UserProfile profile = (UserProfile)session.getAttribute(Constant.UserProfileSession);
		 timeline.setUserName(profile.getName());
		 System.out.println("AAAAAAAAAAA");
		return timeline;
	}
	
	
	
	
	

	
	
}
