package gr.Accenture2.TradingPlatform.web.json.entity;

import gr.Accenture2.TradingPlatform.core.entity.Trade;

import java.util.List;
import java.util.Set;

/**
 * @author Billy
 *
 */
/**
 * @author Billy
 *
 */
public class ApiNewOrderData {
	
	ApiCompany company;

	Float oneStockBuyPrice;
	Float oneStockBuyPriceWithfeesAndTaxes;
	Float oneStockBuyfeesAndTaxes;

	Float oneStockSellPrice;
	Float oneStockSellPriceWithfeesAndTaxes;
	Float oneStockSellfeesAndTaxes;
	
	Float requestedStockBuyPrice; // not used
	Float requestedStockBuyPriceWithfeesAndTaxes;
	Float requestedStockBuyfeesAndTaxes;

	Float requestedStockSellPrice;  // not used
	Float requestedStockSellPriceWithfeesAndTaxes;
	Float requestedStockSellfeesAndTaxes;
	
	Long avaiableStockForPurchase;
	
	Long numberOfUserPurchaseStock;
	
	List<Trade> buyLastTrades;
	
	List<Trade> sellLastTrades;
	
	Integer volume;
	
	ApiLastTrades buyLastTrade1;
	
	ApiLastTrades buyLastTrade2;

	ApiLastTrades buyLastTrade3;
	
	ApiLastTrades sellLastTrade1;
	
	ApiLastTrades sellLastTrade2;
	
	ApiLastTrades sellLastTrade3;

	public ApiCompany getCompany() {
		return company;
	}

	public void setCompany(ApiCompany company) {
		this.company = company;
	}

	public Float getOneStockBuyPrice() {
		return oneStockBuyPrice;
	}

	public void setOneStockBuyPrice(Float oneStockBuyPrice) {
		this.oneStockBuyPrice = oneStockBuyPrice;
	}

	public Float getOneStockBuyPriceWithfeesAndTaxes() {
		return oneStockBuyPriceWithfeesAndTaxes;
	}

	public void setOneStockBuyPriceWithfeesAndTaxes(
			Float oneStockBuyPriceWithfeesAndTaxes) {
		this.oneStockBuyPriceWithfeesAndTaxes = oneStockBuyPriceWithfeesAndTaxes;
	}

	public Float getOneStockBuyfeesAndTaxes() {
		return oneStockBuyfeesAndTaxes;
	}

	public void setOneStockBuyfeesAndTaxes(Float oneStockBuyfeesAndTaxes) {
		this.oneStockBuyfeesAndTaxes = oneStockBuyfeesAndTaxes;
	}

	public Float getOneStockSellPrice() {
		return oneStockSellPrice;
	}

	public void setOneStockSellPrice(Float oneStockSellPrice) {
		this.oneStockSellPrice = oneStockSellPrice;
	}

	public Float getOneStockSellPriceWithfeesAndTaxes() {
		return oneStockSellPriceWithfeesAndTaxes;
	}

	public void setOneStockSellPriceWithfeesAndTaxes(
			Float oneStockSellPriceWithfeesAndTaxes) {
		this.oneStockSellPriceWithfeesAndTaxes = oneStockSellPriceWithfeesAndTaxes;
	}

	public Float getOneStockSellfeesAndTaxes() {
		return oneStockSellfeesAndTaxes;
	}

	public void setOneStockSellfeesAndTaxes(Float oneStockSellfeesAndTaxes) {
		this.oneStockSellfeesAndTaxes = oneStockSellfeesAndTaxes;
	}

	public Float getRequestedStockBuyPrice() {
		return requestedStockBuyPrice;
	}

	public void setRequestedStockBuyPrice(Float requestedStockBuyPrice) {
		this.requestedStockBuyPrice = requestedStockBuyPrice;
	}

	public Float getRequestedStockBuyPriceWithfeesAndTaxes() {
		return requestedStockBuyPriceWithfeesAndTaxes;
	}

	public void setRequestedStockBuyPriceWithfeesAndTaxes(
			Float requestedStockBuyPriceWithfeesAndTaxes) {
		this.requestedStockBuyPriceWithfeesAndTaxes = requestedStockBuyPriceWithfeesAndTaxes;
	}

	public Float getRequestedStockBuyfeesAndTaxes() {
		return requestedStockBuyfeesAndTaxes;
	}

	public void setRequestedStockBuyfeesAndTaxes(Float requestedStockBuyfeesAndTaxes) {
		this.requestedStockBuyfeesAndTaxes = requestedStockBuyfeesAndTaxes;
	}

	public Float getRequestedStockSellPrice() {
		return requestedStockSellPrice;
	}

	public void setRequestedStockSellPrice(Float requestedStockSellPrice) {
		this.requestedStockSellPrice = requestedStockSellPrice;
	}

	public Float getRequestedStockSellPriceWithfeesAndTaxes() {
		return requestedStockSellPriceWithfeesAndTaxes;
	}

	public void setRequestedStockSellPriceWithfeesAndTaxes(
			Float requestedStockSellPriceWithfeesAndTaxes) {
		this.requestedStockSellPriceWithfeesAndTaxes = requestedStockSellPriceWithfeesAndTaxes;
	}

	public Float getRequestedStockSellfeesAndTaxes() {
		return requestedStockSellfeesAndTaxes;
	}

	public void setRequestedStockSellfeesAndTaxes(
			Float requestedStockSellfeesAndTaxes) {
		this.requestedStockSellfeesAndTaxes = requestedStockSellfeesAndTaxes;
	}

	public Long getAvaiableStockForPurchase() {
		return avaiableStockForPurchase;
	}

	public void setAvaiableStockForPurchase(Long avaiableStockForPurchase) {
		this.avaiableStockForPurchase = avaiableStockForPurchase;
	}

	public Long getNumberOfUserPurchaseStock() {
		return numberOfUserPurchaseStock;
	}

	public void setNumberOfUserPurchaseStock(Long numberOfUserPurchaseStock) {
		this.numberOfUserPurchaseStock = numberOfUserPurchaseStock;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public List<Trade> getBuyLastTrades() {
		return buyLastTrades;
	}

	public void setBuyLastTrades(List<Trade> buyLastTrades) {
		this.buyLastTrades = buyLastTrades;
	}

	public List<Trade> getSellLastTrades() {
		return sellLastTrades;
	}

	public void setSellLastTrades(List<Trade> sellLastTrades) {
		this.sellLastTrades = sellLastTrades;
	}

	public ApiLastTrades getBuyLastTrade1() {
		return buyLastTrade1;
	}

	public void setBuyLastTrade1(ApiLastTrades buyLastTrade1) {
		this.buyLastTrade1 = buyLastTrade1;
	}

	public ApiLastTrades getBuyLastTrade2() {
		return buyLastTrade2;
	}

	public void setBuyLastTrade2(ApiLastTrades buyLastTrade2) {
		this.buyLastTrade2 = buyLastTrade2;
	}

	public ApiLastTrades getBuyLastTrade3() {
		return buyLastTrade3;
	}

	public void setBuyLastTrade3(ApiLastTrades buyLastTrade3) {
		this.buyLastTrade3 = buyLastTrade3;
	}

	public ApiLastTrades getSellLastTrade1() {
		return sellLastTrade1;
	}

	public void setSellLastTrade1(ApiLastTrades sellLastTrade1) {
		this.sellLastTrade1 = sellLastTrade1;
	}

	public ApiLastTrades getSellLastTrade2() {
		return sellLastTrade2;
	}

	public void setSellLastTrade2(ApiLastTrades sellLastTrade2) {
		this.sellLastTrade2 = sellLastTrade2;
	}

	public ApiLastTrades getSellLastTrade3() {
		return sellLastTrade3;
	}

	public void setSellLastTrade3(ApiLastTrades sellLastTrade3) {
		this.sellLastTrade3 = sellLastTrade3;
	}



	
	
}
