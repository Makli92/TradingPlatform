package gr.Accenture2.TradingPlatform.web.json.entity;

import java.util.Date;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.enumeration.TradeSide;
import gr.Accenture2.TradingPlatform.core.enumeration.TradeStatus;

public class TradeView {
	private Company company;
	
	private Date tradeDate;
	
	private TradeSide side;
	
	private int quantity;
	
	private Float orderPriceWithFeeTaxes;
	
	private Float unitPrice;
	
	private TradeStatus status;

	public String getCompany() {
		return company.getName();
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public TradeSide getSide() {
		return side;
	}

	public void setSide(TradeSide side) {
		this.side = side;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Float getOrderPriceWithFeeTaxes() {
		return orderPriceWithFeeTaxes;
	}

	public void setOrderPriceWithFeeTaxes(Float orderPriceWithFeeTaxes) {
		this.orderPriceWithFeeTaxes = orderPriceWithFeeTaxes;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public TradeStatus getStatus() {
		return status;
	}

	public void setStatus(TradeStatus status) {
		this.status = status;
	}
	
	
}
