package gr.Accenture2.TradingPlatform.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.repository.service.CompanyRepository;
import gr.Accenture2.TradingPlatform.service.CompanyService;
import gr.Accenture2.TradingPlatform.service.StockService;
import gr.Accenture2.TradingPlatform.service.TradeService;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
public class HomePageController {

	/** The logger in use by this controller. */
	private static final Logger LOGGER = LoggerFactory.getLogger(HomePageController.class);


	@Autowired
	private CompanyService companyService;
	
	
	@Autowired 
	SecurityService securityService;
	
	@Autowired 
	StockService stockService;
	
	@Autowired 
	TradeService tradeService;
	
	@Autowired 
	UserService userService;
	
	//@RequestMapping(value = "/{pageName}", method = RequestMethod.GET)
	//@ResponseBody
	
	@RequestMapping("/")
	public ModelAndView showPage(Model model) {
		
		LOGGER.debug("This is a test debug log");
		
		ModelAndView mnv = new ModelAndView("index");

        return mnv;
    }
	
	
	@RequestMapping("/dashboard")
	public ModelAndView showDashboard( Model model) {
	
		LOGGER.debug("This is a test debug log");
		
		ModelAndView mnv = new ModelAndView("dashboard");
	
		mnv.addObject("username",securityService.findLoggedInUsername());

        return mnv;
    }
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}

	
	@RequestMapping("/save")
	public ModelAndView createCompany() throws Exception {
		
		//companyService.createCompany("Accenture", 10L, 10);
			
		//LOGGER.debug("findUnpurchasedStocks:{}", stockService.findUnpurchasedStocks(2));
		
		LOGGER.debug("findPurchasedStocks:{}",stockService.findPurchasedStocks(companyService.findByName("Accenture"), 2));
	
		//tradeService.purchaseStocks(companyService.findByName("Accenture"), 2, userService.findByUsername("Bill"));
		
		ModelAndView mnv = new ModelAndView("index");
	    return mnv;
	}
	
}
