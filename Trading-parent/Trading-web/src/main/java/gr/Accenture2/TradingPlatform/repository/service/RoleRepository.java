package gr.Accenture2.TradingPlatform.repository.service;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import gr.Accenture2.TradingPlatform.core.entity.Role;
import gr.Accenture2.TradingPlatform.core.entity.User;

@Transactional
public interface RoleRepository extends CrudRepository<Role, String> {

	public Role findByRole(String role);
	
}
