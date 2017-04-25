package gr.Accenture2.TradingPlatform.repository.service;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.Stock;

@Transactional
public interface StockRepository extends CrudRepository<Stock, Long>, JpaRepository<Stock, Long> {
	
	public Set<Stock> findByCompany(Company company);
	
	@Query("SELECT s FROM Stock s WHERE s.id NOT IN (SELECT ust.Stock.id FROM UserStockTrade ust WHERE ust.active = true )")
	public Page<Stock> findUnpurchasedStocks(Pageable pageable);
	
	@Query("SELECT s FROM Stock s WHERE s.company = :company1 AND s.id IN (SELECT ust.Stock.id FROM UserStockTrade ust WHERE ust.active = true )")
	public Page<Stock> findPurchasedStocks(@Param(value = "company1") Company company, Pageable pageable);
	
}
