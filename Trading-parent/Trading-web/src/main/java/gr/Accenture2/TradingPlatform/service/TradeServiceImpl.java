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
import gr.Accenture2.TradingPlatform.repository.service.TradeRepository;
import gr.Accenture2.TradingPlatform.repository.service.UserRepository;

@Service
public class TradeServiceImpl implements TradeService {
	
	
	@Autowired 
	StockService stockService;
	
	@Autowired 
	UserStockTradeService userStockTradeService;
	
	@Autowired
	private TradeRepository tradeRepository;
	
	/**
	 * Price * Number of stocks
	 * 
	 * @param company
	 * @param numberOfStocks
	 * @return
	 */
	public Float calculatePriceWithoutFeeTaxes(Company company, int numberOfStocks, TradeSide side){
		
		if(side == TradeSide.BUY){
			
			return (company.getBuyPrice() * numberOfStocks);
			
		}else{
			
			return (company.getSellprice() * numberOfStocks);
			
		}
	
	}
	
	
	/**
	 * When Buying apply 0.5% taxes + 0 euro fees
	 * 
	 * @param company
	 * @param numberOfStocks
	 * @return
	 */
	public Float calculatePurchasePriceWithFeeTaxes(Company company, int numberOfStocks){
		
		
		
		
			return calculatePriceWithoutFeeTaxes(company, numberOfStocks, TradeSide.BUY)
					+ (calculatePriceWithoutFeeTaxes(company, numberOfStocks, TradeSide.BUY) * TradeSide.BUY.getTaxes())
					+ TradeSide.BUY.getFees() ;

	}
	
	/**
	 * When Selling apply 0.5% taxes + 3 euro fees
	 * 
	 * @param company
	 * @param numberOfStocks
	 * @return
	 */
	public Float calculateSellPriceWithFeeTaxes(Company company, int numberOfStocks){
		
			return (calculatePriceWithoutFeeTaxes(company, numberOfStocks, TradeSide.SELL)
					- (calculatePriceWithoutFeeTaxes(company, numberOfStocks, TradeSide.SELL) * TradeSide.SELL.getTaxes()))
					- TradeSide.SELL.getFees();

	}
	
	
	
	
	public boolean purchaseStocks(Company company, Integer numberOfStocks, User user) throws TradingPlatformTradeException{
		
		Set<Stock> stocks = stockService.findUnpurchasedStocks(company, numberOfStocks);
		
		TradingPlatformTradeException ex;
		
		if (stocks.size() != numberOfStocks){
			
			ex = new TradingPlatformTradeException();
			
			ex.setFault(new Fault(FaultId.UNPURCHASED_STOCKS_NOT_AVAILABLE));
			
			throw ex;
		}
		
		
		Trade trade = new Trade();
		trade.setSide(TradeSide.BUY);
		trade.setUnit_price(company.getBuyPrice());
		trade.setQuantity(stocks.size());
		trade.setOrderPriceWithoutFeeTaxes(calculatePriceWithoutFeeTaxes(company,stocks.size(), TradeSide.BUY));
		trade.setOrderPriceWithFeeTaxes(calculatePurchasePriceWithFeeTaxes(company,stocks.size()));

		if(user.getCashBalance() < trade.getOrderPriceWithFeeTaxes()){
			
			ex = new TradingPlatformTradeException();
			
			ex.setFault(new Fault(FaultId.NOT_ENOUPH_BALANCE));
			
			throw ex;
			
		}
		
	
		user.setCashBalance(new Float(user.getCashBalance().floatValue()- trade.getOrderPriceWithFeeTaxes()));
		
		
		
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
		
		Set<UserStockTrade> userStockTrades = userStockTradeService.findUserStockTrades(company, user, numberOfStocks);
		
		TradingPlatformTradeException ex;
		
		if (userStockTrades.size() != numberOfStocks){
			
			ex = new TradingPlatformTradeException();
			
			ex.setFault(new Fault(FaultId.PURCHASED_STOCKS_NOT_AVAILABLE));
			
			throw ex;
		}
		
		
		Trade trade = new Trade();
		trade.setSide(TradeSide.SELL);
		trade.setUnit_price(company.getSellprice());
		trade.setQuantity(userStockTrades.size());
		trade.setOrderPriceWithoutFeeTaxes(calculatePriceWithoutFeeTaxes(company,userStockTrades.size(), TradeSide.SELL));
		trade.setOrderPriceWithFeeTaxes(calculateSellPriceWithFeeTaxes(company,userStockTrades.size()));
		user.setCashBalance(new Float(user.getCashBalance() + trade.getOrderPriceWithFeeTaxes()));
		
		
		UserStockTrade userStockTrade;
		
		Iterator iter = userStockTrades.iterator();
		while (iter.hasNext()) {
			
			userStockTrade = (UserStockTrade)iter.next();
			
			userStockTrade.setActive(false);
			userStockTradeService.save(userStockTrade);
			
		}
		
		tradeRepository.save(trade);
		
		return true;
	}

}
