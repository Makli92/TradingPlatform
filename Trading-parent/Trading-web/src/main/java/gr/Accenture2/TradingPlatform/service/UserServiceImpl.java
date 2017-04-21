package gr.Accenture2.TradingPlatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.Accenture2.TradingPlatform.core.entity.User;

import gr.Accenture2.TradingPlatform.repository.service.UserRepository;

//http://www.ekiras.com/2016/04/authenticate-user-with-custom-user-details-service-in-spring-security.html

/**
 * @author Billy
 * 
 * User service that encapsulates all the User business login
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	

	public User findByUsername(String username){
		return userRepository.findByUsername(username);
		
//		User user = new User();
//		user.setUsername(username);
//		user.setPassword("password"+ username.substring(4));
//		Set<Role> roles = new HashSet<Role>();
//		Role temp1 = new Role();
//		temp1.setRole("User");
//		roles.add(temp1);
//		user.setRoles(roles);
//
//		return user;
		
	}


	public Long save(User user) {
		return userRepository.save(user).getId();
	}


	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	
}
