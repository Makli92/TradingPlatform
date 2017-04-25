package gr.Accenture2.TradingPlatform.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gr.Accenture2.TradingPlatform.web.auth.service.SecurityService;

@Controller
@EnableAutoConfiguration
public class NavigationController {

	/** The logger in use by this controller. */
	private static final Logger LOGGER = LoggerFactory.getLogger(NavigationController.class);

	@Autowired 
	SecurityService securityService;
	
	@RequestMapping("/portfolio")
	public ModelAndView showPortfolioPage(Model model) {
		
		LOGGER.debug("Open up portfolio");
		
		ModelAndView mnv = new ModelAndView("portfolio");
		mnv.addObject("username", securityService.findLoggedInUsername());

        return mnv;
    }
	
	@RequestMapping("/trades")
	public ModelAndView showTradesPage(Model model) {

		LOGGER.debug("Open up trades' tab");
		
		ModelAndView mnv = new ModelAndView("tradesView");
		mnv.addObject("username", securityService.findLoggedInUsername());

        return mnv;
    }
}
