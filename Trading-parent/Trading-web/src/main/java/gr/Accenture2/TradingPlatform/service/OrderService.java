package gr.Accenture2.TradingPlatform.service;

//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.repository.CrudRepository;

import gr.Accenture2.TradingPlatform.core.entity.Order;

@Transactional
public interface OrderService extends CrudRepository<Order, Long> {

	public Order findById(long id);
}
