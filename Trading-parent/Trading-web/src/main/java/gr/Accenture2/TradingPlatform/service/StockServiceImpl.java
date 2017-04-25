package gr.Accenture2.TradingPlatform.service;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.Stock;
import gr.Accenture2.TradingPlatform.repository.service.StockRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {
	
	@Autowired
	StockRepository stockRepository;
	
	public Set<Stock> findUnpurchasedStocks( Integer numberOfStocks ){
		
		PageRequest pageRequest = new PageRequest(0, numberOfStocks);
		
		Set<Stock> targetCollection = new HashSet<Stock>();
		CollectionUtils.addAll(targetCollection, stockRepository.findUnpurchasedStocks(pageRequest).iterator());
		
		return targetCollection;
		
	}
	
	
	public Set<Stock> findPurchasedStocks(Company company, Integer numberOfStocks ){
		
		PageRequest pageRequest = new PageRequest(0, numberOfStocks);
		
		Set<Stock> targetCollection = new HashSet<Stock>();
		CollectionUtils.addAll(targetCollection, stockRepository.findPurchasedStocks(company, pageRequest).iterator());
		
		return targetCollection;
		
	}
	
	
	
	
	public Set<Stock> generateNewCompanyStocks(Integer numberOfStocks, Company parentCompany){
		
		HashSet hashset = new  HashSet();
		
		 for(int x = 1; x<= numberOfStocks ; x++){
			 
			 Stock stock = new Stock();
			 stock.setCompany(parentCompany);
			 hashset.add(stock);
			 
		 };
		
		return hashset;
	}

}
