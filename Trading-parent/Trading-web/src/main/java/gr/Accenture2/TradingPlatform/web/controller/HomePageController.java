package gr.Accenture2.TradingPlatform.web.controller;

import gr.Accenture2.TradingPlatform.service.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class HomePageController {

	/** The logger in use by this controller. */
	private static final Logger LOGGER = LoggerFactory.getLogger(HomePageController.class);

	@Autowired
	UserService userService;
	
	//@RequestMapping(value = "/{pageName}", method = RequestMethod.GET)
	//@ResponseBody
	
	@RequestMapping("/")
	public String showPage( Model model) {
		
		LOGGER.debug("This is a test debug log, userService:{}", userService.findByUsername("user1"));
		
        return "home";
    }

	@RequestMapping("/login")
	public String showLogin( Model model) {
		
        return "login";
    }
	
	
	@RequestMapping("/Autologin")
	public String showAutologin( Model model) {
		
		LOGGER.debug("showAutologin");

        return "login";
    }
	
	
	
	@RequestMapping("/dashboard")
	public String showDashboard( Model model) {
	
		
        return "dashboard";
    }
	
	
}
