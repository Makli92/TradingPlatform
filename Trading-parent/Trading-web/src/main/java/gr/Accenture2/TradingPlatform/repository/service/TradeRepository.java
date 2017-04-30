package gr.Accenture2.TradingPlatform.repository.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.Trade;
import gr.Accenture2.TradingPlatform.core.enumeration.TradeSide;

@Transactional
public interface TradeRepository extends CrudRepository<Trade, String> {

	public List<Trade> findByTradeDateBetweenAndCompany(Date from, Date to, Company company);

	public List<Trade> findByTradeDateBetweenAndCompanyAndSide(Date from, Date to, Company company, TradeSide side);

	public List<Trade> findByTradeDateBetweenAndSide(Date from, Date to, TradeSide side);
	
	public List<Trade> findByTradeDateBetween(Date from, Date to);
	
	public List<Trade> findFirst3BySideOrderByIdDesc(TradeSide side);
	
	
//	@Query("SELECT t FROM Trade t WHERE t.trade_date BETWEEN :from AND :to" )
//	public List<Trade> getTrades(@Param(value = "from") Date from, @Param(value = "to") Date to);
//	
//	@Query("SELECT t FROM Trade t WHERE t.trade_date BETWEEN :from AND :to AND t.company.name = :company" )
//	public List<Trade> getTrades(@Param(value = "from") Date from, @Param(value = "to") Date to, @Param(value = "company") String company);
}
