package gr.Accenture2.TradingPlatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.repository.service.CompanyRepository;
import gr.Accenture2.TradingPlatform.repository.service.RoleRepository;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	StockService stockService;
	
	public void createCompany(String name, long price, Integer numberOfStock){
		
		Company company = new Company();
		
		company.setName(name);
		company.setPrice(price);
		
		company.setStocks(stockService.generateNewCompanyStocks(numberOfStock, company));
		
		companyRepository.save(company);
	}
	
	
	public Company findByName(String name){
		
		return companyRepository.findByName(name);
		
	}

}
