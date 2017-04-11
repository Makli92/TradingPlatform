package gr.Accenture2.TradingPlatform.web.controller;

import javax.servlet.http.HttpServletRequest;

import gr.Accenture2.TradingPlatform.core.entity.Fault;
import gr.Accenture2.TradingPlatform.core.enumaration.StringEnumeration;
import gr.Accenture2.TradingPlatform.core.enumaration.SupportedLanguage;
import gr.Accenture2.TradingPlatform.core.exception.TradingPlatformAuthenticationException;
import gr.Accenture2.TradingPlatform.web.auth.service.SecurityService;
import gr.Accenture2.TradingPlatform.web.enumeration.RestResponseStatus;
import gr.Accenture2.TradingPlatform.web.json.response.AuthenticationResponse;
import gr.Accenture2.TradingPlatform.web.json.response.GenericResponse;
import gr.Accenture2.TradingPlatform.web.json.response.GenericRestResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	private static final Logger LOGGER = LoggerFactory.getLogger(WebServiceController.class);

	@Autowired 
	SecurityService securityService;
	
	@Autowired 
	private MessageSource messageSource;
	
	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	@ResponseBody
	public GenericRestResponse showAuth( Model model, @RequestParam("username") final String username, @RequestParam("password") final String password) throws TradingPlatformAuthenticationException {
		
		final GenericResponse response = new GenericResponse();
		
		securityService.autologin(username, password);
		
		response.setResponseStatusMessage(RestResponseStatus.OK.getName());

		response.setItem(new AuthenticationResponse(AuthenticationResponse.Status.OK.getStatus(), null));

        return response;
    }

	/**
	 * Handle exceptions of the following types:<br>
	 * <ul>
	 * <li>{@link CosmoteDataException}</li>
	 * <li>{@link CosmoteValidationException}</li>
	 * <li>{@link MissingServletRequestParameterException}</li>
	 * <li>{@link Exception}</li>
	 * </ul>
	 * <br>
	 * Keep in mind that the exception used as parameter must be parent of all handled exceptions.
	 * 
	 * @param exception the parent of all handled exception, currently .
	 * @param request the request of type {@link HttpServletRequest}.
	 * @return the {@link GenericResponse} object which includes our error response we communicate to the client.
	 */
	@ExceptionHandler({TradingPlatformAuthenticationException.class, Exception.class})
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public GenericResponse<String> handleException(final Exception exception, final HttpServletRequest request) {
		
		final GenericResponse result = new GenericResponse();
		if (exception instanceof TradingPlatformAuthenticationException) {

			final Fault fault = ((TradingPlatformAuthenticationException) exception).getFault();
			
			fault.getFaultId().getIdRef();
			
			result.setResponseStatus(RestResponseStatus.OK.getName());

			result.setItem(new AuthenticationResponse(AuthenticationResponse.Status.NOT_OK.getStatus(), messageSource.getMessage(StringEnumeration.ERROR_MESSAGE.getString() + fault.getFaultId().getIdRefToString(), null,
					SupportedLanguage.GREEK.getLocale())));

		}else{
			
			result.setResponseStatus(RestResponseStatus.ERROR.getName());
			
			result.setResponseStatusMessage(messageSource.getMessage(StringEnumeration.ERROR_MESSAGE.getString() + "1", null,
					SupportedLanguage.GREEK.getLocale()));

		}
	
		LOGGER.error(exception.getMessage(), exception);
		return result;
	}
	
}
