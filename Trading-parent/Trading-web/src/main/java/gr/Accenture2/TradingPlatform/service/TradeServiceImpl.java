package gr.Accenture2.TradingPlatform.service;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.Fault;
import gr.Accenture2.TradingPlatform.core.entity.Stock;
import gr.Accenture2.TradingPlatform.core.entity.Trade;
import gr.Accenture2.TradingPlatform.core.entity.User;
import gr.Accenture2.TradingPlatform.core.entity.UserStockTrade;
import gr.Accenture2.TradingPlatform.core.enumeration.FaultId;
import gr.Accenture2.TradingPlatform.core.enumeration.TradeSide;
import gr.Accenture2.TradingPlatform.core.exception.TradingPlatformTradeException;

@Service
public class TradeServiceImpl implements TradeService {
	
	
	@Autowired 
	StockService stockService;
	
	@Autowired 
	UserStockTradeService userStockTradeService;
	
	final static float BUY_TAXES = 0.5f;
	
	
	public boolean purchaseStocks(Company company, Integer numberOfStocks, User user) throws TradingPlatformTradeException{
		
		Set<Stock> stocks = stockService.findUnpurchasedStocks(numberOfStocks);
		
		TradingPlatformTradeException ex;
		
		if (stocks.size() < numberOfStocks){
			
			ex = new TradingPlatformTradeException();
			
			ex.setFault(new Fault(FaultId.UNPURCHASED_STOCKS_NOT_AVAILABLE));
			
			throw ex;
		}
		
		
		Trade trade = new Trade();
		trade.setSide(TradeSide.BUY);
		trade.setUnit_price(company.getPrice());
		trade.setQuantity(stocks.size());
		trade.setOrderPriceWithoutFeeTaxes(company.getPrice() * stocks.size());
		trade.setOrderPriceWithFeeTaxes(trade.getOrderPriceWithoutFeeTaxes() + (trade.getOrderPriceWithoutFeeTaxes() * BUY_TAXES));

		if(user.getCashBalance() < trade.getOrderPriceWithFeeTaxes()){
			
			ex = new TradingPlatformTradeException();
			
			ex.setFault(new Fault(FaultId.NOT_ENOUPH_BALANCE));
			
			throw ex;
			
		}
		
		
		
		user.setCashBalance(user.getCashBalance() - trade.getOrderPriceWithFeeTaxes());
		
		
		
		UserStockTrade userStockTrade;
		
		Iterator iter = stocks.iterator();
		while (iter.hasNext()) {
			
			userStockTrade = new  UserStockTrade();
			userStockTrade.setTrade(trade);
			userStockTrade.setActive(true);
			userStockTrade.setStock((Stock)iter.next());
			userStockTrade.setUser(user);
			
			userStockTradeService.save(userStockTrade);
			
		}
		
		
		
		return true;
	}
	
	
	public boolean sellStocks(Company company, Integer numberOfStocks, User user) throws TradingPlatformTradeException{
		
		Set<Stock> stocks = stockService.findPurchasedStocks(company, numberOfStocks);
		
		TradingPlatformTradeException ex;
		
		if (stocks.size() < numberOfStocks){
			
			ex = new TradingPlatformTradeException();
			
			ex.setFault(new Fault(FaultId.UNPURCHASED_STOCKS_NOT_AVAILABLE));
			
			throw ex;
		}
		
		
		Trade trade = new Trade();
		trade.setSide(TradeSide.BUY);
		trade.setUnit_price(company.getPrice());
		trade.setQuantity(stocks.size());
		trade.setOrderPriceWithoutFeeTaxes(company.getPrice() * stocks.size());
		trade.setOrderPriceWithFeeTaxes(trade.getOrderPriceWithoutFeeTaxes() + (trade.getOrderPriceWithoutFeeTaxes() * BUY_TAXES));

		if(user.getCashBalance() < trade.getOrderPriceWithFeeTaxes()){
			
			ex = new TradingPlatformTradeException();
			
			ex.setFault(new Fault(FaultId.NOT_ENOUPH_BALANCE));
			
			throw ex;
			
		}
		
		
		
		user.setCashBalance(user.getCashBalance() - trade.getOrderPriceWithFeeTaxes());
		
		
		
		UserStockTrade userStockTrade;
		
		Iterator iter = stocks.iterator();
		while (iter.hasNext()) {
			
			userStockTrade = new  UserStockTrade();
			userStockTrade.setTrade(trade);
			userStockTrade.setActive(true);
			userStockTrade.setStock((Stock)iter.next());
			userStockTrade.setUser(user);
			
			userStockTradeService.save(userStockTrade);
			
		}
		
		
		
		return true;
	}

}
