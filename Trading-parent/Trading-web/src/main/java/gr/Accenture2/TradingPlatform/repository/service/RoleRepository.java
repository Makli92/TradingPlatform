package gr.Accenture2.TradingPlatform.repository.service;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.repository.CrudRepository;

import gr.Accenture2.TradingPlatform.core.entity.Role;

@Transactional
public interface RoleRepository extends CrudRepository<Role, String> {

	public Role findByRole(String role);
	
}
