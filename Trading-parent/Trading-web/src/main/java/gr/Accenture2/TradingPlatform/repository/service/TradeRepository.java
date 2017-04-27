package gr.Accenture2.TradingPlatform.repository.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.CrudRepository;
import gr.Accenture2.TradingPlatform.core.entity.Trade;

@Transactional
public interface TradeRepository extends CrudRepository<Trade, String> {
	
	
	
}
