package gr.Accenture2.TradingPlatform.repository.service;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import gr.Accenture2.TradingPlatform.core.entity.User;

@Transactional
public interface UserRepository extends CrudRepository<User, String> {

	//public User findByUsername(String username);
	
	public User findByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.username = :username  AND enabled=true" )
	public User findByUsername (@Param(value = "username") String username);

}
