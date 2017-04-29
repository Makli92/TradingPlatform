package gr.Accenture2.TradingPlatform.web.json.entity;

import gr.Accenture2.TradingPlatform.core.entity.Company;

public class Portfolio {

	private ApiCompany company;
	
	private Long quantity;
	
	private Float nominalValue;
	
	private Float value;
	
	private Float portfolioPercentage;
	
	private String newOrderUrl;

	public ApiCompany getCompany() {
		return company;
	}

	public void setCompany(ApiCompany company) {
		this.company = company;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Float getNominalValue() {
		return nominalValue;
	}

	public void setNominalValue(Float nominalValue) {
		this.nominalValue = nominalValue;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Float getPortfolioPercentage() {
		return portfolioPercentage;
	}

	public void setPortfolioPercentage(Float portfolioPercentage) {
		this.portfolioPercentage = portfolioPercentage;
	}

	public String getNewOrderUrl() {
		return newOrderUrl;
	}

	public void setNewOrderUrl(String newOrderUrl) {
		this.newOrderUrl = newOrderUrl;
	}
	
}
