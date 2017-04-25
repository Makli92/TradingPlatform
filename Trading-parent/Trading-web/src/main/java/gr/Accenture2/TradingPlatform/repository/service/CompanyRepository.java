package gr.Accenture2.TradingPlatform.repository.service;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;

import gr.Accenture2.TradingPlatform.core.entity.Company;

@Transactional
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {

	public Company findByName(String name);
	
	
}
