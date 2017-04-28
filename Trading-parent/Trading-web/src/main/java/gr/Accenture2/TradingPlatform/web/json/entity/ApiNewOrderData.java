package gr.Accenture2.TradingPlatform.web.json.entity;

/**
 * @author Billy
 *
 */
public class ApiNewOrderData {
	
	ApiCompany company;

	Float oneStockBuyPrice;
	Float oneStockBuyfeesAndTaxes;
	
	Float requestedStockBuyPrice;
	Float requestedStockBuyfeesAndTaxes;
	
	Float oneStockSellPrice;
	Float oneStockSellfeesAndTaxes;
	
	Float requestedStockSellPrice;
	Float requestedStockSellfeesAndTaxes;
	
	Float oneStockPriceWithoutFeesAndTaxes;
	Float requestedStockPriceWithoutFeesAndTaxes;
	
	Long avaiableStockForPurchase;
	
	Long numberOfUserPurchaseStock;
	
	public Long getAvaiableStockForPurchase() {
		return avaiableStockForPurchase;
	}
	public void setAvaiableStockForPurchase(Long avaiableStockForPurchase) {
		this.avaiableStockForPurchase = avaiableStockForPurchase;
	}
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
	public Float getOneStockBuyfeesAndTaxes() {
		return oneStockBuyfeesAndTaxes;
	}
	public void setOneStockBuyfeesAndTaxes(Float oneStockBuyfeesAndTaxes) {
		this.oneStockBuyfeesAndTaxes = oneStockBuyfeesAndTaxes;
	}
	public Float getRequestedStockBuyPrice() {
		return requestedStockBuyPrice;
	}
	public void setRequestedStockBuyPrice(Float requestedStockBuyPrice) {
		this.requestedStockBuyPrice = requestedStockBuyPrice;
	}
	public Float getRequestedStockBuyfeesAndTaxes() {
		return requestedStockBuyfeesAndTaxes;
	}
	public void setRequestedStockBuyfeesAndTaxes(Float requestedStockBuyfeesAndTaxes) {
		this.requestedStockBuyfeesAndTaxes = requestedStockBuyfeesAndTaxes;
	}
	public Float getOneStockSellPrice() {
		return oneStockSellPrice;
	}
	public void setOneStockSellPrice(Float oneStockSellPrice) {
		this.oneStockSellPrice = oneStockSellPrice;
	}
	public Float getOneStockSellfeesAndTaxes() {
		return oneStockSellfeesAndTaxes;
	}
	public void setOneStockSellfeesAndTaxes(Float oneStockSellfeesAndTaxes) {
		this.oneStockSellfeesAndTaxes = oneStockSellfeesAndTaxes;
	}
	public Float getRequestedStockSellPrice() {
		return requestedStockSellPrice;
	}
	public void setRequestedStockSellPrice(Float requestedStockSellPrice) {
		this.requestedStockSellPrice = requestedStockSellPrice;
	}
	public Float getRequestedStockSellfeesAndTaxes() {
		return requestedStockSellfeesAndTaxes;
	}
	public void setRequestedStockSellfeesAndTaxes(
			Float requestedStockSellfeesAndTaxes) {
		this.requestedStockSellfeesAndTaxes = requestedStockSellfeesAndTaxes;
	}
	public Float getOneStockPriceWithoutFeesAndTaxes() {
		return oneStockPriceWithoutFeesAndTaxes;
	}
	public void setOneStockPriceWithoutFeesAndTaxes(
			Float oneStockPriceWithoutFeesAndTaxes) {
		this.oneStockPriceWithoutFeesAndTaxes = oneStockPriceWithoutFeesAndTaxes;
	}
	public Float getRequestedStockPriceWithoutFeesAndTaxes() {
		return requestedStockPriceWithoutFeesAndTaxes;
	}
	public void setRequestedStockPriceWithoutFeesAndTaxes(
			Float requestedStockPriceWithoutFeesAndTaxes) {
		this.requestedStockPriceWithoutFeesAndTaxes = requestedStockPriceWithoutFeesAndTaxes;
	}
	public Long getNumberOfUserPurchaseStock() {
		return numberOfUserPurchaseStock;
	}
	public void setNumberOfUserPurchaseStock(Long numberOfUserPurchaseStock) {
		this.numberOfUserPurchaseStock = numberOfUserPurchaseStock;
	}

}
