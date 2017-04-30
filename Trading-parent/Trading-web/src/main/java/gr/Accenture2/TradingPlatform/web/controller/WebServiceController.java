package gr.Accenture2.TradingPlatform.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.Fault;
import gr.Accenture2.TradingPlatform.core.entity.Role;
import gr.Accenture2.TradingPlatform.core.entity.Trade;
import gr.Accenture2.TradingPlatform.core.entity.User;
import gr.Accenture2.TradingPlatform.core.enumeration.BundleKey;
import gr.Accenture2.TradingPlatform.core.enumeration.StringEnumeration;
import gr.Accenture2.TradingPlatform.core.enumeration.SupportedLanguage;
import gr.Accenture2.TradingPlatform.core.enumeration.TradeSide;
import gr.Accenture2.TradingPlatform.core.exception.TradingPlatformAuthenticationException;
import gr.Accenture2.TradingPlatform.core.exception.TradingPlatformTradeException;
import gr.Accenture2.TradingPlatform.repository.service.CompanyRepository;
import gr.Accenture2.TradingPlatform.repository.service.StockRepository;
import gr.Accenture2.TradingPlatform.service.CompanyService;
import gr.Accenture2.TradingPlatform.service.PortfolioService;
import gr.Accenture2.TradingPlatform.service.RoleService;
import gr.Accenture2.TradingPlatform.service.StockService;
import gr.Accenture2.TradingPlatform.service.TradeService;
import gr.Accenture2.TradingPlatform.service.UserService;
import gr.Accenture2.TradingPlatform.service.UserStockTradeService;
import gr.Accenture2.TradingPlatform.web.auth.service.SecurityService;
import gr.Accenture2.TradingPlatform.web.enumeration.RestResponseStatus;
import gr.Accenture2.TradingPlatform.web.json.entity.ApiCompany;
import gr.Accenture2.TradingPlatform.web.json.entity.ApiLastTrades;
import gr.Accenture2.TradingPlatform.web.json.entity.ApiNewOrderData;
import gr.Accenture2.TradingPlatform.web.json.entity.ApiUser;
import gr.Accenture2.TradingPlatform.web.json.entity.Portfolio;
import gr.Accenture2.TradingPlatform.web.json.entity.TradeView;
import gr.Accenture2.TradingPlatform.web.json.response.AuthenticationResponse;
import gr.Accenture2.TradingPlatform.web.json.response.BuyStocksResponse;
import gr.Accenture2.TradingPlatform.web.json.response.CompaniesResponse;
import gr.Accenture2.TradingPlatform.web.json.response.ForgotResponse;
import gr.Accenture2.TradingPlatform.web.json.response.GenericResponse;
import gr.Accenture2.TradingPlatform.web.json.response.GenericRestResponse;
import gr.Accenture2.TradingPlatform.web.json.response.NewOrderDataResponse;
import gr.Accenture2.TradingPlatform.web.json.response.PortfolioResponse;
import gr.Accenture2.TradingPlatform.web.json.response.RegistrationResponse;
import gr.Accenture2.TradingPlatform.web.json.response.SellStocksResponse;
import gr.Accenture2.TradingPlatform.web.json.response.UserDataResponse;
import gr.Accenture2.TradingPlatform.web.json.response.TradeViewResponse;
import gr.Accenture2.TradingPlatform.web.post.request.RegistrationForm;
import gr.Accenture2.TradingPlatform.web.service.FormValidationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@EnableAutoConfiguration
@RequestMapping("/services")
public class WebServiceController {

	/** The logger in use by this controller. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(WebServiceController.class);
	
	@Autowired
	SecurityService securityService;

	@Autowired
	UserService userService; 
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private FormValidationService formValidationService;
	
	@Autowired 
	TradeService tradeService;
	
	@Autowired
	UserStockTradeService userStockTradeService;

	@Autowired
	PortfolioService portfolioService;

	/**
	 * The authentication API service for login.
	 * 
	 * API endpoint: [host]:[port]/services/auth HTTP method: POST POST
	 * paramethers: * username * password
	 * 
	 * Temp working passwords: user1/password1 Temp not working passwords:
	 * user1/password2
	 * 
	 * @param model
	 * @param username
	 * @param password
	 * @return
	 * @throws TradingPlatformAuthenticationException
	 */
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	// RequestMethod.POST must be used instead
	@ResponseBody
	public GenericRestResponse showAuth(Model model,
			@RequestParam("username") final String username,
			@RequestParam("password") final String password)
			throws TradingPlatformAuthenticationException {

		final GenericResponse response = new GenericResponse();

		securityService.autologin(username, password);

		response.setResponseStatus(RestResponseStatus.OK.getName());

		response.setItem(new AuthenticationResponse(
				AuthenticationResponse.Status.OK.getStatus(), null));

		return response;
	}

	/**
	 * The forgot password API service
	 * 
	 * 
	 * API endpoint: [host]:[port]/services/forgot HTTP method: POST POST
	 * paramethers: * email
	 * 
	 * 
	 * @param model
	 * @param username
	 * @param password
	 * @return
	 * @throws TradingPlatformAuthenticationException
	 */
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	// RequestMethod.POST must be used instead
	@ResponseBody
	public GenericRestResponse showForgot(Model model,
			@RequestParam("email") final String email)
			throws TradingPlatformAuthenticationException {

		final GenericResponse response = new GenericResponse();

		// TODO send password here

		response.setResponseStatus(RestResponseStatus.OK.getName());

		response.setItem(new ForgotResponse(ForgotResponse.Status.OK
				.getStatus(), messageSource.getMessage(
				BundleKey.FORGOT_MESSAGE.getKey(), null,
				SupportedLanguage.GREEK.getLocale())));

		return response;
	}

	/**
	 * The registration api service
	 * 
	 * API endpoint: [host]:[port]/services/register HTTP method: POST POST
	 * paramethers: * firstname * lastname * birthDate * mobile * username *
	 * password * passwordConfirm * email
	 * 
	 * @param model
	 * @param username
	 * @param password
	 * @return
	 * @throws TradingPlatformAuthenticationException
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	// RequestMethod.POST must be used instead
	@ResponseBody
	public GenericRestResponse showRegistration(
			RegistrationForm registrationForm, BindingResult bindingResult,
			Model model) throws TradingPlatformAuthenticationException, Exception {

		final GenericResponse response = new GenericResponse();

		formValidationService.validate(registrationForm, bindingResult);

		RegistrationResponse registrationResponse = new RegistrationResponse();

		if (bindingResult.hasErrors()) {

			registrationResponse
					.setRegistrationStatus(RegistrationResponse.Status.NOT_OK
							.getStatus());

			for (ObjectError item : bindingResult.getAllErrors()) {

				registrationResponse.addRegistrationStatusMessage(messageSource
						.getMessage(item.getCode(), null,
								SupportedLanguage.GREEK.getLocale()));

			}

		} else {
			
			User user = userService.findByUsername(registrationForm.getUsername());

			if (user != null){
				
				registrationResponse.addRegistrationStatusMessage(messageSource
						.getMessage("userAlreadyExists", null,
								SupportedLanguage.GREEK.getLocale()));
				
				response.setResponseStatus(RestResponseStatus.ERROR.getName());
				response.setItem(registrationResponse);
				
				
				return response;
			}
			
			// TODO register user
			
			user = new User();
			
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        String dateInString = "7-Jun-2013";


	            Date date = formatter.parse(registrationForm.getBirthDate());
	            System.out.println(date);
	            System.out.println(formatter.format(date));


			
			user.setFirstName(registrationForm.getFirstname());
			user.setLastName(registrationForm.getLastname());
			user.setMobile(registrationForm.getMobile());
			user.setEmail(registrationForm.getEmail());
			user.setBirthDate(date);
			user.setEnabled(true);
			user.setPassword(registrationForm.getPassword());
			user.setUsername(registrationForm.getUsername());
			user.setCashBalance(1000F);
			user.setRoles(new HashSet<Role>());
		
			user.getRoles().add(roleService.findByRole(StringEnumeration.USER.getString()));
			
			userService.save(user);

			registrationResponse
					.setRegistrationStatus(RegistrationResponse.Status.OK
							.getStatus());

		}

		response.setResponseStatus(RestResponseStatus.OK.getName());
		response.setItem(registrationResponse);

		return response;
	}
	
	/**
	 * The user data API service, for login and update profile
	 * 
	 * API endpoint: [host]:[port]/services/getUserData HTTP method: GET
	 * paramethers: none
	 * 
	 * 
	 * @param model
	 * @param username
	 * @param password
	 * @return
	 * @throws TradingPlatformAuthenticationException
	 */
	@RequestMapping(value = "/getUserData", method = RequestMethod.GET)
	// RequestMethod.POST must be used instead
	@ResponseBody
	public GenericRestResponse showGetUserData(Model model)
			throws TradingPlatformAuthenticationException {

		final GenericResponse response = new GenericResponse();

		ApiUser apiUser = new ApiUser();
	
		BeanUtils.copyProperties(userService.findByUsername(securityService.findLoggedInUsername()), apiUser);
		
		response.setResponseStatus(RestResponseStatus.OK.getName());

		response.setItem(new UserDataResponse(
				UserDataResponse.Status.OK.getStatus(), null, apiUser));

		return response;
	}
	
	
	/**
	 * The user data API service, for updating Stock prices
	 * 
	 * API endpoint: [host]:[port]/services/getNewOrderData HTTP method: GET
	 * paramethers: none
	 * 
	 * E.G : http://localhost:8080/services/getNewOrderData
	 * 
	 * @param model
	 * @param username
	 * @param password
	 * @return
	 * @throws TradingPlatformAuthenticationException
	 */
	@RequestMapping(value = "/getNewOrderData", method = RequestMethod.POST)
	// RequestMethod.POST must be used instead
	@ResponseBody
	public GenericRestResponse showGetNewOrderData(Model model,
			@RequestParam("companyId") final String companyId,
			@RequestParam("requestedStocks") String requestedStocks)
			throws TradingPlatformAuthenticationException {

		final GenericResponse response = new GenericResponse();

		ApiNewOrderData apiNewOrderData = new ApiNewOrderData();
		
		Company company = companyService.findById(Long.parseLong(companyId));
		
		ApiCompany tempApiCompany = new ApiCompany();
		BeanUtils.copyProperties(company, tempApiCompany);

		apiNewOrderData.setCompany(tempApiCompany);
		
		Integer requestedStocksInteger = Integer.parseInt(requestedStocks);;
		
		
		apiNewOrderData.setOneStockBuyPrice(tradeService.calculatePriceWithoutFeeTaxes(company, 1, TradeSide.BUY));
		apiNewOrderData.setOneStockBuyPriceWithfeesAndTaxes(tradeService.calculatePurchasePriceWithFeeTaxes(company, 1));
		apiNewOrderData.setOneStockBuyfeesAndTaxes(apiNewOrderData.getOneStockBuyPriceWithfeesAndTaxes()-apiNewOrderData.getOneStockBuyPrice());

		apiNewOrderData.setOneStockSellPrice(tradeService.calculatePriceWithoutFeeTaxes(company, 1, TradeSide.SELL));
		apiNewOrderData.setOneStockSellPriceWithfeesAndTaxes(tradeService.calculateSellPriceWithFeeTaxes(company, 1));
		apiNewOrderData.setOneStockSellfeesAndTaxes(apiNewOrderData.getOneStockSellPriceWithfeesAndTaxes() - apiNewOrderData.getOneStockSellPriceWithfeesAndTaxes() );
		
		apiNewOrderData.setRequestedStockBuyPrice(tradeService.calculatePriceWithoutFeeTaxes(company, requestedStocksInteger, TradeSide.BUY));
		apiNewOrderData.setRequestedStockBuyPriceWithfeesAndTaxes(tradeService.calculatePurchasePriceWithFeeTaxes(company, requestedStocksInteger));
		apiNewOrderData.setRequestedStockBuyfeesAndTaxes(apiNewOrderData.getRequestedStockBuyPriceWithfeesAndTaxes() - apiNewOrderData.getRequestedStockBuyPrice());

		apiNewOrderData.setRequestedStockSellPrice(tradeService.calculatePriceWithoutFeeTaxes(company, requestedStocksInteger, TradeSide.SELL));
		apiNewOrderData.setRequestedStockSellPriceWithfeesAndTaxes(tradeService.calculateSellPriceWithFeeTaxes(company, requestedStocksInteger));
		apiNewOrderData.setRequestedStockSellfeesAndTaxes(apiNewOrderData.getRequestedStockSellPrice() - apiNewOrderData.getRequestedStockSellPriceWithfeesAndTaxes());
		
		apiNewOrderData.setAvaiableStockForPurchase(stockService.getAvaiableStockForPurchase(company));
		
		apiNewOrderData.setNumberOfUserPurchaseStock(userStockTradeService.getNumberOfUserStockTrades(company, userService.findByUsername(securityService.findLoggedInUsername())));
		
		//apiNewOrderData.setBuyLastTrades( tradeService.findTop3BySideOrderByIdDesc(TradeSide.BUY));
		
		//apiNewOrderData.setSellLastTrades(tradeService.findTop3BySideOrderByIdDesc(TradeSide.SELL));
		
		
		Iterator it;
		Iterator it2;
		Trade tempTradeTrade;
		
		//apiNewOrderData.setBuyLastTrades(new HashSet()) ;
		
		
		it = tradeService.findTop3BySideOrderByIdDesc(TradeSide.BUY).iterator();
		
		LOGGER.debug("test1:{}" + tradeService.findTop3BySideOrderByIdDesc(TradeSide.BUY).size());
		
		int i  = 1;
		
		while(it.hasNext()){
			
			tempTradeTrade = (Trade)it.next();
			
			if(i == 1){
				apiNewOrderData.setBuyLastTrade1(new ApiLastTrades(tempTradeTrade.getId(), tempTradeTrade.getUnitPrice(), tempTradeTrade.getQuantity()));
					
			}else if(i == 2){
				
				apiNewOrderData.setBuyLastTrade2(new ApiLastTrades(tempTradeTrade.getId(), tempTradeTrade.getUnitPrice(), tempTradeTrade.getQuantity()));
				
			}else if(i == 3){
				
				apiNewOrderData.setBuyLastTrade3(new ApiLastTrades(tempTradeTrade.getId(), tempTradeTrade.getUnitPrice(), tempTradeTrade.getQuantity()));
				
			}
			/*
			
		
			LOGGER.debug("test2:{}" + tempTradeTrade.getId());
			
			apiNewOrderData.getBuyLastTrades().add(new ApiLastTrades(tempTradeTrade.getId(), tempTradeTrade.getUnitPrice(), tempTradeTrade.getQuantity()));
*/
			i++;
		}
		
		
		//LOGGER.debug("test3:{}" + apiNewOrderData.getBuyLastTrades().size());
		
		//apiNewOrderData.setSellLastTrades(new HashSet()) ;
		
		it2 =  tradeService.findTop3BySideOrderByIdDesc(TradeSide.SELL).iterator();
		i  = 1;
		
		while(it2.hasNext()){
			
			tempTradeTrade = (Trade)it2.next();
			
			if(i == 1){
				apiNewOrderData.setSellLastTrade1(new ApiLastTrades(tempTradeTrade.getId(), tempTradeTrade.getUnitPrice(), tempTradeTrade.getQuantity()));
					
			}else if(i == 2){
				
				apiNewOrderData.setSellLastTrade2(new ApiLastTrades(tempTradeTrade.getId(), tempTradeTrade.getUnitPrice(), tempTradeTrade.getQuantity()));
				
			}else if(i == 3){
				
				apiNewOrderData.setSellLastTrade3(new ApiLastTrades(tempTradeTrade.getId(), tempTradeTrade.getUnitPrice(), tempTradeTrade.getQuantity()));
				
			}
			
			//apiNewOrderData.getSellLastTrades().add(new ApiLastTrades(tempTradeTrade.getId(),tempTradeTrade.getUnitPrice(), tempTradeTrade.getQuantity()));
			i++;
		}
		
		
		 Calendar cal = Calendar.getInstance();
		 cal.set(Calendar.HOUR_OF_DAY, 0);
		 cal.set(Calendar.MINUTE, 0);
		 cal.set(Calendar.SECOND, 0);
		 cal.set(Calendar.MILLISECOND,0);
		 Date fromDate = cal.getTime();
		 Date toDate = new Date();
		
		 apiNewOrderData.setVolume(tradeService.getTrades(fromDate, toDate).size());
		
		tradeService.calculatePurchasePriceWithFeeTaxes(company, 1);

		response.setResponseStatus(RestResponseStatus.OK.getName());

		response.setItem(new NewOrderDataResponse(
				NewOrderDataResponse.Status.OK.getStatus(), null, apiNewOrderData));

		return response;
	}

	/**
	 * The user data API service, for buying stocks
	 * 
	 * API endpoint: [host]:[port]/services/buyStocks HTTP method: GET
	 * paramethers: none
	 * 
	 * E.G : http://localhost:8080/services/buyStocks
	 * 
	 * @param model
	 * @param username
	 * @param password
	 * @return
	 * @throws TradingPlatformAuthenticationException
	 */
	@RequestMapping(value = "/buyStocks", method = RequestMethod.POST)
	// RequestMethod.POST must be used instead
	@ResponseBody
	public GenericRestResponse showBuyStocks(Model model,
			@RequestParam("companyId") final String companyId,
			@RequestParam("requestedStocks") String requestedStocks)
			throws TradingPlatformAuthenticationException {

		final GenericResponse response = new GenericResponse();

		Company company = companyService.findById(Long.parseLong(companyId));
		
		try{
		
			tradeService.purchaseStocks(company, Integer.parseInt(requestedStocks), userService.findByUsername(securityService.findLoggedInUsername()));
		
		}catch(TradingPlatformTradeException tpte){
	

			response.setResponseStatus(RestResponseStatus.OK.getName());

			response.setItem(new BuyStocksResponse(
					BuyStocksResponse.Status.NOT_OK.getStatus(), messageSource.getMessage(BundleKey.ERROR_MESSAGE.getKey()
							+ tpte.getFault().getFaultId().getIdRefToString(), null,
							SupportedLanguage.GREEK.getLocale()),null));

			return response;
		}
		
		response.setResponseStatus(RestResponseStatus.OK.getName());

		response.setItem(new BuyStocksResponse(
				BuyStocksResponse.Status.OK.getStatus(), null,null));

		return response;
	}
	
	
	/**
	 * The user data API service, for selling stocks
	 * 
	 * API endpoint: [host]:[port]/services/sellStocks HTTP method: GET
	 * paramethers: none
	 * 
	 * E.G : http://localhost:8080/services/sellStocks
	 * 
	 * @param model
	 * @param username
	 * @param password
	 * @return
	 * @throws TradingPlatformAuthenticationException
	 */
	@RequestMapping(value = "/sellStocks", method = RequestMethod.POST)
	// RequestMethod.POST must be used instead
	@ResponseBody
	public GenericRestResponse showSellStocks(Model model,
			@RequestParam("companyId") final String companyId,
			@RequestParam("requestedStocks") String requestedStocks)
			throws TradingPlatformAuthenticationException {

		final GenericResponse response = new GenericResponse();

		Company company = companyService.findById(Long.parseLong(companyId));
		
		try{
		
			tradeService.sellStocks(company,Integer.parseInt(requestedStocks),userService.findByUsername(securityService.findLoggedInUsername()));
			
		}catch(TradingPlatformTradeException tpte){
	

			response.setResponseStatus(RestResponseStatus.OK.getName());

			response.setItem(new SellStocksResponse(
					SellStocksResponse.Status.NOT_OK.getStatus(), messageSource.getMessage(BundleKey.ERROR_MESSAGE.getKey()
							+ tpte.getFault().getFaultId().getIdRefToString(), null,
							SupportedLanguage.GREEK.getLocale()),null));

			return response;
		}
		
		response.setResponseStatus(RestResponseStatus.OK.getName());

		response.setItem(new SellStocksResponse(
				SellStocksResponse.Status.OK.getStatus(), null,null));

		return response;
	}
	
	
	/**
	 * The user data API service, for search autocomplete
	 * 
	 * API endpoint: [host]:[port]/services/getCompanies HTTP method: GET
	 * paramethers: none
	 * 
	 * 
	 * @param model
	 * @param username
	 * @param password
	 * @return
	 * @throws TradingPlatformAuthenticationException
	 */
	@RequestMapping(value = "/getCompanies", method = RequestMethod.GET)
	// RequestMethod.POST must be used instead
	@ResponseBody
	public GenericRestResponse showGetCompanies(Model model)
			throws TradingPlatformAuthenticationException {

		final GenericResponse response = new GenericResponse();

		
		Iterable iterable = companyService.gatAllCompanies();
		
	    HashSet<ApiCompany> set = new HashSet<ApiCompany>();
	    Iterator<Company> it = iterable.iterator();
	    
	    ApiCompany tempApiCompany;
	    
	    while (it.hasNext()) {
	    	
	    	tempApiCompany = new ApiCompany();
	    	
			BeanUtils.copyProperties((Company)it.next(), tempApiCompany);
			
	    	
	        set.add(tempApiCompany);
	    }
		
		response.setResponseStatus(RestResponseStatus.OK.getName());

		response.setItem(new CompaniesResponse(
				CompaniesResponse.Status.OK.getStatus(), null, set));

		return response;
	}
	
	
	/**
	 * Just an API to test authenticated users. You must be logged in in order
	 * to access this api
	 * 
	 * @param model
	 * @return
	 * @throws TradingPlatformAuthenticationException
	 */
	@RequestMapping(value = "/private", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public GenericRestResponse showPrivate(Model model)
			throws TradingPlatformAuthenticationException {

		final GenericResponse response = new GenericResponse();

		response.setResponseStatus(RestResponseStatus.OK.getName());

		response.setItem(new AuthenticationResponse(
				AuthenticationResponse.Status.OK.getStatus(), null));

		return response;
	}

	/**
	 * 
	 * The api that the browser will be redirected in case it requests an API
	 * service that needs authentication. This settings is configured in
	 * MultiHttpSecurityConfig.class
	 * 
	 * @param model
	 * @return
	 * @throws TradingPlatformAuthenticationException
	 */
	@RequestMapping(value = "/unauthorize", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public GenericRestResponse showUnauthorize(Model model)
			throws TradingPlatformAuthenticationException {

		final GenericResponse response = new GenericResponse();

		response.setResponseStatus(RestResponseStatus.UNAUTHORIZED.getName());

		return response;
	}

	/**
	 * Handle exceptions of the following types:<br>
	 * <ul>
	 * <li>{@link MissingServletRequestParameterException}</li>
	 * <li>{@link Exception}</li>
	 * </ul>
	 * <br>
	 * Keep in mind that the exception used as parameter must be parent of all
	 * handled exceptions.
	 * 
	 * @param exception
	 *            the parent of all handled exception, currently .
	 * @param request
	 *            the request of type {@link HttpServletRequest}.
	 * @return the {@link GenericResponse} object which includes our error
	 *         response we communicate to the client.
	 */
	@ExceptionHandler({ TradingPlatformAuthenticationException.class,
			Exception.class })
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public GenericResponse<String> handleException(Exception exception,
			final HttpServletRequest request) {

		final GenericResponse result = new GenericResponse();
		if (exception instanceof TradingPlatformAuthenticationException ||
				exception instanceof UsernameNotFoundException) {

			if(exception instanceof UsernameNotFoundException){
				
				exception = new TradingPlatformAuthenticationException();
			}
			

			
			// Authentication error

			final Fault fault = ((TradingPlatformAuthenticationException) exception)
					.getFault();

			fault.getFaultId().getIdRef();

			result.setResponseStatus(RestResponseStatus.OK.getName());

			result.setItem(new AuthenticationResponse(
					AuthenticationResponse.Status.NOT_OK.getStatus(),
					messageSource.getMessage(BundleKey.ERROR_MESSAGE.getKey()
							+ fault.getFaultId().getIdRefToString(), null,
							SupportedLanguage.GREEK.getLocale())));

		} else {

			// General type of error

			result.setResponseStatus(RestResponseStatus.ERROR.getName());

			result.setResponseStatusMessage(messageSource.getMessage(
					BundleKey.ERROR_MESSAGE.getKey()
							+ StringEnumeration.ONE.getString(), null,
					SupportedLanguage.GREEK.getLocale()));

		}

		LOGGER.error(exception.getMessage(), exception);
		return result;
	}

	/**
	 * The trade view data API service, for global trades presentation
	 * 
	 * API endpoint: [host]:[port]/services/trades HTTP method: GET
	 * paramethers: none
	 * 
	 * 
	 * @param model
	 * @return
	 * @throws TradingPlatformAuthenticationException
	 * @throws TradingPlatformTradeException 
	 */
	@RequestMapping(value = "/trades", method = RequestMethod.GET)
	@ResponseBody
	public GenericRestResponse showTrades(	Model model, 
											@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date from,
											@RequestParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") Date to,
											@RequestParam(value = "side", required = false, defaultValue = "") String side,
											@RequestParam(value = "company", required = false, defaultValue = "") String company)
			throws TradingPlatformAuthenticationException, TradingPlatformTradeException {

		final GenericResponse response = new GenericResponse();
		
		Calendar c = Calendar.getInstance(); 
		c.setTime(to); 
		c.add(Calendar.DATE, 1);
		
		List<TradeView> tradeViews = tradeService.getTradeView(from, c.getTime(), side, company);
		
		response.setResponseStatus(RestResponseStatus.OK.getName());
		response.setItem(new TradeViewResponse(TradeViewResponse.Status.OK.getStatus(), null, tradeViews));

		return response;
	}
	



	/**
	 * The portfolio view data API service
	 * 
	 * API endpoint: [host]:[port]/services/portfolio HTTP method: GET
	 * paramethers: company
	 * 
	 * 
	 * @param model
	 * @return
	 * @throws TradingPlatformAuthenticationException
	 * @throws TradingPlatformTradeException 
	 */
	@RequestMapping(value = "/portfolio", method = RequestMethod.GET)
	@ResponseBody
	public GenericRestResponse showPortfolio(	Model model, 
											@RequestParam(value = "company", required = false, defaultValue = "") String company) {
	
		final GenericResponse response = new GenericResponse();
		
		
		
		Set<Portfolio> portfolioView = portfolioService.getPortfolioViews(company, userService.findByUsername(securityService.findLoggedInUsername()));
		
		response.setResponseStatus(RestResponseStatus.OK.getName());
		response.setItem(new PortfolioResponse(PortfolioResponse.Status.OK.getStatus(), null, portfolioView));
	
		return response;
	}

}

