package gr.Accenture2.TradingPlatform.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gr.Accenture2.TradingPlatform.core.entity.User;
import gr.Accenture2.TradingPlatform.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable String username) {
		return userService.findByUsername(username);
	}
}
