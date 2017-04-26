package gr.Accenture2.TradingPlatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.Accenture2.TradingPlatform.core.entity.Role;
import gr.Accenture2.TradingPlatform.core.entity.User;
import gr.Accenture2.TradingPlatform.repository.service.RoleRepository;
import gr.Accenture2.TradingPlatform.repository.service.UserRepository;

//http://www.ekiras.com/2016/04/authenticate-user-with-custom-user-details-service-in-spring-security.html

/**
 * @author Billy
 * 
 * User service that encapsulates all the User business login
 *
 */
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Role findByRole(String role){
		
		return roleRepository.findByRole(role);
		
	}
	
	public Role save(Role role){
		
		return roleRepository.save(role);
	}
	
	
}
