package gr.Accenture2.TradingPlatform.service;

import java.util.List;
import java.util.Set;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.Trade;
import gr.Accenture2.TradingPlatform.core.entity.User;
import gr.Accenture2.TradingPlatform.core.exception.TradingPlatformTradeException;

public interface TradeService {

	boolean purchaseStocks(Company company, Integer numberOfStocks, User user) throws TradingPlatformTradeException;
	
	public boolean sellStocks(Company company, Integer numberOfStocks, User user) throws TradingPlatformTradeException;
	
	public List<Trade> getTrades() throws TradingPlatformTradeException;
	
}
