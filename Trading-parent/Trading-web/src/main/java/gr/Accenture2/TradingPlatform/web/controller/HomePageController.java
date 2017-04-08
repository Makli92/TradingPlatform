package gr.Accenture2.TradingPlatform.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	
	//@RequestMapping(value = "/{pageName}", method = RequestMethod.GET)
	//@ResponseBody
	
	@RequestMapping("/")
	public String showPage( Model model) {
		
		LOGGER.debug("This is a test debug log");
		
        return "index";
    }
	
}
