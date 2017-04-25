package gr.Accenture2.TradingPlatform.service;

import java.util.Set;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.User;
import gr.Accenture2.TradingPlatform.core.entity.UserStockTrade;

public interface UserStockTradeService {

	public UserStockTrade save(UserStockTrade userStockTrade);
	
	public Set<UserStockTrade> findUserStockTrades(Company company, User user, Integer numberOfUserStockTrades);
	
}
