package gr.Accenture2.TradingPlatform.web.auth.service;

import gr.Accenture2.TradingPlatform.core.exception.TradingPlatformAuthenticationException;

public interface SecurityService {
	
    String findLoggedInUsername();

    void autologin(String username, String password) throws TradingPlatformAuthenticationException;
}
