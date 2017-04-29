package gr.Accenture2.TradingPlatform.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.Fault;
import gr.Accenture2.TradingPlatform.core.entity.Stock;
import gr.Accenture2.TradingPlatform.core.entity.Trade;
import gr.Accenture2.TradingPlatform.core.entity.User;
import gr.Accenture2.TradingPlatform.core.entity.UserStockTrade;
import gr.Accenture2.TradingPlatform.core.enumeration.FaultId;
import gr.Accenture2.TradingPlatform.core.enumeration.TradeSide;
import gr.Accenture2.TradingPlatform.core.exception.TradingPlatformTradeException;
import gr.Accenture2.TradingPlatform.repository.service.TradeRepository;
import gr.Accenture2.TradingPlatform.web.controller.WebServiceController;
import gr.Accenture2.TradingPlatform.web.json.entity.ApiCompany;
import gr.Accenture2.TradingPlatform.web.json.entity.Portfolio;
import gr.Accenture2.TradingPlatform.web.json.entity.TradeView;

@Service
public class PortfolioServiceImpl implements PortfolioService {
	

	/** The logger in use by this controller. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(WebServiceController.class);
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	UserStockTradeService userStockTradeService;
	
	public Set<Portfolio> getPortfolioViews(String company, User user){
		
		Set<Company> companies = companyService.getPortfolioCompanies(user);
		
		LOGGER.debug("getPortfolioViews: {}", companies);
		
		Iterator it = companies.iterator();
		
		HashSet <Portfolio> portofoioView = new HashSet();
		
		Portfolio tempPortfolio;
		
		ApiCompany tempApiCompany;
		Company tempCompany;
		
		
		while(it.hasNext()){
			
			tempPortfolio = new Portfolio();
			
			tempApiCompany = new ApiCompany();
			
			tempCompany = (Company)it.next();
			
			BeanUtils.copyProperties(tempCompany, tempApiCompany);
			
			tempPortfolio.setCompany(tempApiCompany);
			
			tempPortfolio.setQuantity(userStockTradeService.getNumberOfUserStockTrades(tempCompany, user ));
			
			tempPortfolio.setNominalValue(tempCompany.getSellprice());
		
			tempPortfolio.setValue(tempPortfolio.getNominalValue() * tempPortfolio.getQuantity());
			
			tempPortfolio.setNewOrderUrl("/newOrder/" + tempPortfolio.getCompany().getId() + "/" + tempPortfolio.getCompany().getName());
		
			portofoioView.add(tempPortfolio);
		}
		
		it = portofoioView.iterator();
		
		Float totalValue = 0F;
		
		while(it.hasNext()){
			
			tempPortfolio = ((Portfolio)it.next());
			
			totalValue = tempPortfolio.getValue() + totalValue;

		}
		
		
		if(totalValue == 0F){ // For avoiding 0 divide exception
			
			totalValue = 1F;
		}
		
		it = portofoioView.iterator();
		
		while(it.hasNext()){
			
			tempPortfolio = ((Portfolio)it.next());

			tempPortfolio.setPortfolioPercentage((tempPortfolio.getValue() /  totalValue) * 100);
			
			
		}
		
		
		LOGGER.debug("getPortfolioViews 1" );
		
		it = portofoioView.iterator();
		
		if(company != null || !company.isEmpty()){
		
			LOGGER.debug("getPortfolioViews 2" );
			
			while(it.hasNext()){
				
				LOGGER.debug("getPortfolioViews 3" );
				
				tempPortfolio = ((Portfolio)it.next());
			
				if (!tempPortfolio.getCompany().getName().startsWith(company)){
					
					LOGGER.debug("getPortfolioViews 4" );
					
					it.remove();
					
				}
			}
		
		}
		return portofoioView;
	}
	
}
