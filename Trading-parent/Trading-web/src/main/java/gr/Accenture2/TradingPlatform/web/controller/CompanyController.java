package gr.Accenture2.TradingPlatform.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.repository.service.CompanyRepository;
import gr.Accenture2.TradingPlatform.repository.service.StockRepository;

@RestController
@RequestMapping("/services/companies")
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private StockRepository stockRepository;
	
	@GetMapping("")
	public List<Company> getCompanies() {
		return (List<Company>) companyRepository.findAll();
	}
	
}
