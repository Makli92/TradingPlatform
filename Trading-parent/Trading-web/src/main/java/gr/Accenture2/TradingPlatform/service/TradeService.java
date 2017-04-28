package gr.Accenture2.TradingPlatform.service;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.User;
import gr.Accenture2.TradingPlatform.core.exception.TradingPlatformTradeException;

public interface TradeService {

	boolean purchaseStocks(Company company, Integer numberOfStocks, User user) throws TradingPlatformTradeException;
	
	public boolean sellStocks(Company company, Integer numberOfStocks, User user) throws TradingPlatformTradeException;
	
	public Float calculatePriceWithoutFeeTaxes(Company company, int numberOfStocks);
	
	public Float calculatePurchasePriceWithFeeTaxes(Company company, int numberOfStocks);
	
	public Float calculateSellPriceWithFeeTaxes(Company company, int numberOfStocks);
	
}
