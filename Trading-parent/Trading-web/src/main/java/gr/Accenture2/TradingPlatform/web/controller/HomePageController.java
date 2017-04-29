package gr.Accenture2.TradingPlatform.web.controller;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.Role;
import gr.Accenture2.TradingPlatform.core.entity.User;
import gr.Accenture2.TradingPlatform.core.enumeration.StringEnumeration;
import gr.Accenture2.TradingPlatform.repository.service.CompanyRepository;
import gr.Accenture2.TradingPlatform.service.CompanyService;
import gr.Accenture2.TradingPlatform.service.RoleService;
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
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@Autowired 
	RoleService roleService;
	
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
	
		mnv.addObject("username", securityService.findLoggedInUsername());

        return mnv;
    }
	
	@RequestMapping(value={"/newOrder/{id:[\\d]+}/{name}"})
	public ModelAndView showNewOrder( Model model, @PathVariable("id") Long id, @PathVariable("name") String name) {
	
		LOGGER.debug("showNewOrder, id:{}, name:{}", id, name );
		
		LOGGER.debug("This is a test debug log");
		
		ModelAndView mnv = new ModelAndView("newOrder");
	
		mnv.addObject("username", securityService.findLoggedInUsername());
		
		mnv.addObject("companyId", id);

        return mnv;
    }
	
	@RequestMapping("/newOrder")
	public ModelAndView showNewOrderWitoutParameters( Model model) {
	
		LOGGER.debug("showNewOrder" );
		
		LOGGER.debug("This is a test debug log");
		
		ModelAndView mnv = new ModelAndView("newOrder");
		
		mnv.addObject("companyId", companyService.getFirstCompany().getId());
	
		mnv.addObject("username", securityService.findLoggedInUsername());

        return mnv;
    }

	@RequestMapping("/tradesView")
	public ModelAndView showTradesView( Model model) {
	
		LOGGER.debug("This is a test debug log");
		
		ModelAndView mnv = new ModelAndView("tradesView");
	
		mnv.addObject("username", securityService.findLoggedInUsername());

        return mnv;
    }
	
	@RequestMapping("/portfolio")
	public ModelAndView showportfolio( Model model) {
	
		LOGGER.debug("This is a test debug log");
		
		ModelAndView mnv = new ModelAndView("portfolio");
	
		mnv.addObject("username", securityService.findLoggedInUsername());

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

	
	@RequestMapping("/createData")
	public ModelAndView createData() throws Exception {
		
		Role role = new Role();
		role.setRole("Admin");
		roleService.save(role);
		
		role = new Role();
		role.setRole("User");
		roleService.save(role);
		
		User user1  =  new User();
		user1.setFirstName("Makli firstName");
		user1.setLastName("Makli lastName");
		user1.setMobile("6978366099");
		user1.setUsername("Makli");
		user1.setEnabled(true);
		user1.setCashBalance(new Float(100));
		user1.setPassword("123");
		user1.setEmail("email@gmail.com");
		user1.setRoles(new HashSet<Role>());
		user1.getRoles().add(roleService.findByRole(StringEnumeration.USER.getString()));
		userService.save(user1);
		
		user1  =  new User();
		user1.setFirstName("Themis firstName");
		user1.setLastName("Themis lastName");
		user1.setMobile("6978366098");
		user1.setUsername("Themis");
		user1.setEnabled(true);
		user1.setCashBalance(new Float(100));
		user1.setPassword("132");
		user1.setEmail("test@test.com");
		user1.setRoles(new HashSet<Role>());
		user1.getRoles().add(roleService.findByRole(StringEnumeration.USER.getString()));
		userService.save(user1);
		
		
		user1  =  new User();
		user1.setFirstName("Bill firstName");
		user1.setLastName("Bill lastName");
		user1.setUsername("Bill");
		user1.setMobile("6978366097");
		user1.setEnabled(true);
		user1.setCashBalance(new Float(100));
		user1.setPassword("321");
		user1.setEmail("test@test.com");
		user1.setRoles(new HashSet<Role>());
		user1.getRoles().add(roleService.findByRole(StringEnumeration.USER.getString()));
		userService.save(user1);
		
		companyService.createCompany("Accenture", 19F, 20.1F,100);
		
		companyService.createCompany("Intrasoft", 10F, 10.5F, 100);
		
		companyService.createCompany("Agile Actors", 9F, 9.7F, 100);
	
		tradeService.purchaseStocks(companyService.findByName("Accenture"), 3, userService.findByUsername("Bill"));
		
		
		tradeService.sellStocks(companyService.findByName("Accenture"),1,userService.findByUsername("Bill"));
		
		
		ModelAndView mnv = new ModelAndView("index");
	    return mnv;
	}
	
	@RequestMapping("/test")
	public ModelAndView create() throws Exception {

		//LOGGER.debug("findUnpurchasedStocks:{}", stockService.findUnpurchasedStocks(2));
		
		ModelAndView mnv = new ModelAndView("index");
	    return mnv;
	}
	
	
}
