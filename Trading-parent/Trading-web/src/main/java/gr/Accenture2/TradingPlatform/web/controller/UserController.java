package gr.Accenture2.TradingPlatform.web.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gr.Accenture2.TradingPlatform.core.entity.Role;
import gr.Accenture2.TradingPlatform.service.UserService;

@RestController
@RequestMapping("/services/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/{username}")
	public int getUser(@PathVariable String username) {
		Set<Role> roles = userService.findByUsername(username).getRoles();
		System.out.println(roles.iterator().next().getRole());
		return roles.size();
	}
}
