package gr.Accenture2.TradingPlatform.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.User;
import gr.Accenture2.TradingPlatform.repository.service.CompanyRepository;
import gr.Accenture2.TradingPlatform.repository.service.RoleRepository;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	
	@Autowired
	StockService stockService;
	
	public void createCompany(String name, Float buyPrice, Float sellPrice, Integer numberOfStock){
		
		Company company = new Company();
		
		company.setName(name);
		company.setBuyPrice(buyPrice);
		company.setSellprice(sellPrice);
		
		
		company.setStocks(stockService.generateNewCompanyStocks(numberOfStock, company));
		
		companyRepository.save(company);
	}
	
	
	public Company findByName(String name){
		
		return companyRepository.findByName(name);
		
	}
	
	public Company findById(long id){
		
		return companyRepository.findById(id);
		
	}
	
	public  Iterable<Company> gatAllCompanies(){
		
		return companyRepository.findAll();

		
	}
	
	
	public Company getFirstCompany(){
		
		PageRequest pageRequest = new PageRequest(0, 1);
		
		Iterator it = companyRepository.getFirstCompany(pageRequest).iterator();
		
		while(it.hasNext()){
			
			return ((Company)it.next());
			
		}
		
		return null;
	}


	public Company findByNameStartingWith(String company) {
		return companyRepository.findByNameStartingWith(company);
	}

	public Set<Company> getPortfolioCompanies(User user){
		
		return companyRepository.getPortfolioCompanies(user);
	}
	
}
