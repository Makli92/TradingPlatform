package gr.Accenture2.TradingPlatform.repository.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import gr.Accenture2.TradingPlatform.core.entity.Trade;
import gr.Accenture2.TradingPlatform.core.entity.User;

@Transactional
public interface TradeRepository extends CrudRepository<Trade, String> {


}
