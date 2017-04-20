package gr.Accenture2.TradingPlatform.repository.service;

//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;

import gr.Accenture2.TradingPlatform.repository.entity.Order;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface OrderService extends CrudRepository<Order, Long> {

	public Order findById(long id);
}
