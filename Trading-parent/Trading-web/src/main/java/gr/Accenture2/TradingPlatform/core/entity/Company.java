package gr.Accenture2.TradingPlatform.core.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * @author Billy
 *
 */

/**
 * @author Billy
 *
 */
@Entity
@Table(name = "companies")
@JsonInclude(Include.NON_EMPTY)
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name = "name", nullable = false)
    private String name;
	
	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
	private Set<Stock> stocks;


	public Company() {
		super();
	}

	public Company(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Column(name = "buy_price", nullable = false)
	private Float buyPrice;
	
	
	@Column(name = "price_Update_Date", columnDefinition = "TIMESTAMP", nullable = false)
	private Date priceUpdateDate;
	
	
	@Column(name = "sell_Pice", nullable = false)
	private Float sellprice;
	
	
	@Column(name = "sell_Price_Update_Date", columnDefinition = "TIMESTAMP", nullable = false)
	private Date sellPriceUpdateDate;
	
	
	
	@PrePersist
	void preInsertPriceUpdateDate() {
		priceUpdateDate = new Date();
		sellPriceUpdateDate = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}

	public Float getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Float buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Date getPriceUpdateDate() {
		return priceUpdateDate;
	}

	public void setPriceUpdateDate(Date priceUpdateDate) {
		this.priceUpdateDate = priceUpdateDate;
	}

	public Float getSellprice() {
		return sellprice;
	}

	public void setSellprice(Float sellprice) {
		this.sellprice = sellprice;
	}

	public Date getSellPriceUpdateDate() {
		return sellPriceUpdateDate;
	}

	public void setSellPriceUpdateDate(Date sellPriceUpdateDate) {
		this.sellPriceUpdateDate = sellPriceUpdateDate;
	}


	
}
