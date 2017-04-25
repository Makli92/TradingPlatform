package gr.Accenture2.TradingPlatform.service;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.User;
import gr.Accenture2.TradingPlatform.core.exception.TradingPlatformTradeException;

public interface TradeService {

	boolean purchaseStocks(Company company, Integer numberOfStocks, User user) throws TradingPlatformTradeException;
	
}
