package gr.Accenture2.TradingPlatform.web.json.entity;

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
	
	Integer volume;

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
	
	

	
	
}
