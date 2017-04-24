package gr.Accenture2.TradingPlatform.repository.service;

import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.Stock;

@Transactional
public interface StockRepository extends PagingAndSortingRepository<Stock, Long> {
	
	public Set<Stock> findByCompany(Company company);

}
