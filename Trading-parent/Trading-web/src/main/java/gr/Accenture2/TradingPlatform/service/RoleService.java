package gr.Accenture2.TradingPlatform.service;

import gr.Accenture2.TradingPlatform.core.entity.Role;

public interface RoleService {

	public Role findByRole(String role);
	
	public Role save(Role role);
}
