package gr.Accenture2.TradingPlatform.service;

import java.util.Set;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.User;

public interface CompanyService {

	public void createCompany(String name, long price, Integer numberOfStock);

	public Company findByName(String name);
	
	public  Iterable<Company> gatAllCompanies();
	
	public Company findById(long id);
	
	public Company getFirstCompany();
	
}
