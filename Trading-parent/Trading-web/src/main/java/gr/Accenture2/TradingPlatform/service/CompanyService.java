package gr.Accenture2.TradingPlatform.service;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.User;
import gr.Accenture2.TradingPlatform.core.enumeration.TradeSide;

public interface CompanyService {

	public void createCompany(String name, long price, Integer numberOfStock);

	public Company findByName(String name);

	public Company findByNameStartingWith(String name);
	
}
