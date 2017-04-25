package gr.Accenture2.TradingPlatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.Accenture2.TradingPlatform.core.entity.UserStockTrade;
import gr.Accenture2.TradingPlatform.repository.service.UserStockTradeRepository;


@Service
public class UserStockTradeServiceImpl implements UserStockTradeService {

	@Autowired
	UserStockTradeRepository userStockTradeRepository;
	
	public UserStockTrade save(UserStockTrade userStockTrade){
		
		return userStockTradeRepository.save(userStockTrade);
		
	}

}
