package gr.Accenture2.TradingPlatform.service;

import gr.Accenture2.TradingPlatform.core.entity.User;

public interface UserService {

	public User findByUsername(String username);
	
}