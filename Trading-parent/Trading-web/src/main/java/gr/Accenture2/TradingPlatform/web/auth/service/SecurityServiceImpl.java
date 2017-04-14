package gr.Accenture2.TradingPlatform.web.auth.service;

import gr.Accenture2.TradingPlatform.core.exception.TradingPlatformAuthenticationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService{
    
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SSUserDetailsService userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

    public String findLoggedInUsername() {
    	
    	/*
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }
             
        
        return null;
        */

    	
    	AbstractAuthenticationToken token = (AbstractAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
    	
    	if(token instanceof UsernamePasswordAuthenticationToken){
    		
    		return token.getName();
    		
    	}
    	
    	return null; // this may return "anonymousUser"
        
    	/*
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getDetails();
        return user.getUsername(); //get logged in username
        */
    }

    public void autologin(String username, String password) throws TradingPlatformAuthenticationException {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        try{
        
        	authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        }catch (AuthenticationException ae){
        	
        	throw new TradingPlatformAuthenticationException();
        	
        }
        
        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
    }
}
