package gr.Accenture2.TradingPlatform.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.Trade;
import gr.Accenture2.TradingPlatform.core.entity.User;
import gr.Accenture2.TradingPlatform.core.enumeration.TradeSide;
import gr.Accenture2.TradingPlatform.core.exception.TradingPlatformTradeException;
import gr.Accenture2.TradingPlatform.web.json.entity.TradeView;

public interface TradeService {

	boolean purchaseStocks(Company company, Integer numberOfStocks, User user) throws TradingPlatformTradeException;
	
	public boolean sellStocks(Company company, Integer numberOfStocks, User user) throws TradingPlatformTradeException;
	
	public List<Trade> getTrades(Date from, Date to, Company company, TradeSide side);
	
	public List<Trade> getTrades(Date from, Date to, TradeSide side);

	public List<Trade> getTrades(Date from, Date to, Company company);
	
	public List<Trade> getTrades(Date from, Date to);
	
	public List<TradeView> getTradeView(Date from, Date to, String side, String company);
}
