package gr.Accenture2.TradingPlatform.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.repository.service.CompanyRepository;
import gr.Accenture2.TradingPlatform.repository.service.StockRepository;
import gr.Accenture2.TradingPlatform.service.CompanyService;

@RestController
@RequestMapping("/test/companies")
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private StockRepository stockRepository;
	
	@GetMapping("all")
	public List<Company> getCompanies() {
		return (List<Company>) companyRepository.findAll();
	}
	
	@GetMapping("save")
	public List<Company> createCompany() {
		
		companyService.createCompany("Accenture", 10L, 10);
	
		return (List<Company>) companyRepository.findAll();
	}
	
	
	
}
