package gr.Accenture2.TradingPlatform.web.config;

import gr.Accenture2.TradingPlatform.core.entity.User;
import gr.Accenture2.TradingPlatform.service.UserService;
import gr.Accenture2.TradingPlatform.web.auth.service.SSUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class MultiHttpSecurityConfig {

	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		
	    @Autowired 
	    private UserService userService;
		
		protected void configure(HttpSecurity http) throws Exception {
            http
            .antMatcher("/services/**")
            .authorizeRequests()
            	.antMatchers("/services/auth","/services/unauthorize", "/services/forgot", "/services/register").permitAll()
            	.antMatchers("/services/*").hasAuthority("User")
            	//.antMatchers("/**").permitAll()
                //.anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/services/unauthorize")
                .permitAll()
                .and()
            .logout()
                .permitAll();
		}
		
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsServiceBean());
	    }
	    
	    @Override
	    public UserDetailsService userDetailsServiceBean() throws Exception {
	        return new SSUserDetailsService(userService);
	    }
	}

	@Configuration
	@Order(2)
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	    @Autowired 
	    private UserService userService;
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {

            http
            .authorizeRequests()
            	.antMatchers("/dashboard").hasAuthority("User")
            	.antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
			
		}
		
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsServiceBean());
	    }
	    
	    @Override
	    public UserDetailsService userDetailsServiceBean() throws Exception {
	        return new SSUserDetailsService(userService);
	    }
	}
}