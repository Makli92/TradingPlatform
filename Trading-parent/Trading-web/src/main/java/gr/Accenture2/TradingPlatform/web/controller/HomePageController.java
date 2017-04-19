package gr.Accenture2.TradingPlatform.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.Accenture2.TradingPlatform.service.UserService;
import gr.Accenture2.TradingPlatform.web.auth.service.SecurityService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
public class HomePageController {

	/** The logger in use by this controller. */
	private static final Logger LOGGER = LoggerFactory.getLogger(HomePageController.class);

	@Autowired
	UserService userService;
	
	@Autowired 
	SecurityService securityService;
	
	
	
	//@RequestMapping(value = "/{pageName}", method = RequestMethod.GET)
	//@ResponseBody
	
	@RequestMapping("/")
	public ModelAndView showPage(Model model) {
		
		LOGGER.debug("This is a test debug log");
		
		ModelAndView mnv = new ModelAndView("index");
	
		mnv.addObject("username",securityService.findLoggedInUsername());
	
        return mnv;
    }

	@RequestMapping("/login")
	public String showLogin( Model model) {
		
        return "login";
    }
	
	
	@RequestMapping("/Autologin")
	public String showAutologin( Model model) {
		
		LOGGER.debug("showAutologin");
		
		//securityService.autologin("user1", "password1");
		
        return "login";
    }
	
	
	
	@RequestMapping("/dashboard")
	public String showDashboard( Model model) {
	
		
        return "dashboard";
    }
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}

	
}
