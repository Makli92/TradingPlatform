package gr.Accenture2.TradingPlatform.repository.service;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.Stock;
import gr.Accenture2.TradingPlatform.core.entity.User;

@Transactional
public interface StockRepository extends CrudRepository<Stock, Long>, JpaRepository<Stock, Long> {
	
	public Set<Stock> findByCompany(Company company);
	
	@Query("SELECT s FROM Stock s WHERE s.company = :company1 AND s.id NOT IN (SELECT ust.stock.id FROM UserStockTrade ust WHERE ust.active = true )")
	public Page<Stock> findUnpurchasedStocks(@Param(value = "company1") Company company,Pageable pageable);
	
	@Query("SELECT s FROM Stock s WHERE s.company = :company1 AND s.id IN (SELECT ust.stock.id FROM UserStockTrade ust WHERE ust.active = true )")
	public Page<Stock> findPurchasedStocks(@Param(value = "company1") Company company, Pageable pageable);

	@Query("SELECT COUNT(s) FROM Stock s WHERE s.company = :company1 AND s.id NOT IN (SELECT ust.stock.id FROM UserStockTrade ust WHERE ust.active = true )")
	public Long getAvaiableStockForPurchase(@Param(value = "company1") Company company);
	
}
