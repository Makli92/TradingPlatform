package gr.Accenture2.TradingPlatform.service;

import java.util.Set;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.User;
import gr.Accenture2.TradingPlatform.core.enumeration.TradeSide;

public interface CompanyService {

	public void createCompany(String name, Float price, Float sellPrice, Integer numberOfStock);

	public Company findByName(String name);

	public Company findByNameStartingWith(String name);
	
	public  Iterable<Company> gatAllCompanies();
	
	public Company findById(long id);
	
	public Company getFirstCompany();
	
	public Set<Company>getPortfolioCompanies(User user);
	
	
	
}
