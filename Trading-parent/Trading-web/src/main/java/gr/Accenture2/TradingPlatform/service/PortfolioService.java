package gr.Accenture2.TradingPlatform.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.Trade;
import gr.Accenture2.TradingPlatform.core.entity.User;
import gr.Accenture2.TradingPlatform.core.enumeration.TradeSide;
import gr.Accenture2.TradingPlatform.core.exception.TradingPlatformTradeException;
import gr.Accenture2.TradingPlatform.web.json.entity.Portfolio;
import gr.Accenture2.TradingPlatform.web.json.entity.TradeView;

public interface PortfolioService {

	
	public Set<Portfolio> getPortfolioViews(String company, User user);
	
}
