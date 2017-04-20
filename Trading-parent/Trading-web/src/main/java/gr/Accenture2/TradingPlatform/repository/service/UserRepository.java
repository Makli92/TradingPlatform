package gr.Accenture2.TradingPlatform.repository.service;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import gr.Accenture2.TradingPlatform.core.entity.User;

@Transactional
public interface UserRepository extends CrudRepository<User, String> {

	public User findByUsername(String username);
}
