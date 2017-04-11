package gr.Accenture2.TradingPlatform.repository.daos;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import gr.Accenture2.TradingPlatform.persistence.models.User;

@Transactional
public interface UserDao extends CrudRepository<User, Long> {

  /**
   * Return the user having the passed email or null if no user is found.
   * 
   * @param email the user email.
   */
  public User findByEmail(String email);

}