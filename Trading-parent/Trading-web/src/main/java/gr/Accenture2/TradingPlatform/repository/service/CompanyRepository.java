package gr.Accenture2.TradingPlatform.repository.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.Stock;

@Transactional
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {

	public Company findByName(String name);
	
	@Query("SELECT new Company(c.id, c.name) FROM Company c" )
	public Set<Company> findAllIdAndName();

	public Company findById(long id);
	
	@Query("SELECT c FROM Company c" )
	public Page<Company> getFirstCompany(Pageable pageable);
	
	public Company findByNameStartingWith(String name);
}
