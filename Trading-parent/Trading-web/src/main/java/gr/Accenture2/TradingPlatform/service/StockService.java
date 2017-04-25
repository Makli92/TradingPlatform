package gr.Accenture2.TradingPlatform.service;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.Stock;

import java.util.Set;

import org.springframework.data.domain.Pageable;

public interface StockService  {

	public Set generateNewCompanyStocks(Integer numberOfStocks, Company parentCompany);
	
	public Set<Stock> findUnpurchasedStocks(Company company, Integer numberOfStocks);
	
	public Set<Stock> findPurchasedStocks(Company company, Integer numberOfStocks );
}
