package gr.Accenture2.TradingPlatform.service;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.Stock;
import gr.Accenture2.TradingPlatform.core.entity.User;
import gr.Accenture2.TradingPlatform.core.entity.UserStockTrade;
import gr.Accenture2.TradingPlatform.repository.service.UserStockTradeRepository;


@Service
public class UserStockTradeServiceImpl implements UserStockTradeService {

	@Autowired
	UserStockTradeRepository userStockTradeRepository;
	
	public UserStockTrade save(UserStockTrade userStockTrade){
		
		return userStockTradeRepository.save(userStockTrade);
		
	}
	
	public Set<UserStockTrade> findUserStockTrades(Company company, User user, Integer numberOfUserStockTrades){
		
		PageRequest pageRequest = new PageRequest(0, numberOfUserStockTrades);
		
		Set<UserStockTrade> targetCollection = new HashSet<UserStockTrade>();
		CollectionUtils.addAll(targetCollection, userStockTradeRepository.findUserStockTrades(company, user, pageRequest).iterator());
		
		return targetCollection;
	}

}
