package gr.Accenture2.TradingPlatform.web.controller;

import java.util.HashSet;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.Fault;
import gr.Accenture2.TradingPlatform.core.entity.Role;
import gr.Accenture2.TradingPlatform.core.entity.User;
import gr.Accenture2.TradingPlatform.core.enumeration.BundleKey;
import gr.Accenture2.TradingPlatform.core.enumeration.StringEnumeration;
import gr.Accenture2.TradingPlatform.core.enumeration.SupportedLanguage;
import gr.Accenture2.TradingPlatform.core.exception.TradingPlatformAuthenticationException;
import gr.Accenture2.TradingPlatform.repository.service.CompanyRepository;
import gr.Accenture2.TradingPlatform.repository.service.StockRepository;
import gr.Accenture2.TradingPlatform.service.CompanyService;
import gr.Accenture2.TradingPlatform.service.RoleService;
import gr.Accenture2.TradingPlatform.service.UserService;
import gr.Accenture2.TradingPlatform.web.auth.service.SecurityService;
import gr.Accenture2.TradingPlatform.web.enumeration.RestResponseStatus;
import gr.Accenture2.TradingPlatform.web.json.entity.ApiCompany;
import gr.Accenture2.TradingPlatform.web.json.entity.ApiUser;
import gr.Accenture2.TradingPlatform.web.json.response.AuthenticationResponse;
import gr.Accenture2.TradingPlatform.web.json.response.CompaniesResponse;
import gr.Accenture2.TradingPlatform.web.json.response.ForgotResponse;
import gr.Accenture2.TradingPlatform.web.json.response.GenericResponse;
import gr.Accenture2.TradingPlatform.web.json.response.GenericRestResponse;
import gr.Accenture2.TradingPlatform.web.json.response.RegistrationResponse;
import gr.Accenture2.TradingPlatform.web.json.response.UserDataResponse;
import gr.Accenture2.TradingPlatform.web.post.request.RegistrationForm;
import gr.Accenture2.TradingPlatform.web.service.FormValidationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.MessageSource;
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
	private StockRepository stockRepository;
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private FormValidationService formValidationService;

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
			Model model) throws TradingPlatformAuthenticationException {

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

			// TODO register user
			
			User user = new User();
			
			user.setEmail(registrationForm.getEmail());
			user.setEnabled(true);
			user.setPassword(registrationForm.getPassword());
			user.setUsername(registrationForm.getUsername());
			
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

}
