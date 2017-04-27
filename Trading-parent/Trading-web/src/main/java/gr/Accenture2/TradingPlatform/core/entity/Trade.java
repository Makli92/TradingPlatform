package gr.Accenture2.TradingPlatform.core.entity;

import java.util.Date;
import java.util.Set;

import gr.Accenture2.TradingPlatform.core.enumeration.TradeSide;
import gr.Accenture2.TradingPlatform.core.enumeration.TradeStatus;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Billy
 *
 */
@Entity
@Table(name = "trades")
public class Trade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "trade_date", columnDefinition = "DATETIME")
	private Date tradeDate;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TradeSide side;
	
	private Float orderPriceWithFeeTaxes;
	
	private Float orderPriceWithoutFeeTaxes;

	private Float unitPrice;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TradeStatus status = TradeStatus.COMPLETE;
	
	private int quantity;
	
	@OneToMany(mappedBy = "trade", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
	private Set<UserStockTrade> userStockTrade;

	@ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
	private User user;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "company_id", nullable = false, updatable = false)
	private Company company;
	
	public long getId() {
		return id;
	}

	@PrePersist
	void preInserttradeDate() {
		this.setTradeDate(new Date());
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date trade_date) {
		this.tradeDate = trade_date;
	}

	public Float getOrderPriceWithFeeTaxes() {
		return orderPriceWithFeeTaxes;
	}

	public void setOrderPriceWithFeeTaxes(Float orderPriceWithFeeTaxes) {
		this.orderPriceWithFeeTaxes = orderPriceWithFeeTaxes;
	}

	public Float getOrderPriceWithoutFeeTaxes() {
		return orderPriceWithoutFeeTaxes;
	}

	public void setOrderPriceWithoutFeeTaxes(Float orderPriceWithoutFeeTaxes) {
		this.orderPriceWithoutFeeTaxes = orderPriceWithoutFeeTaxes;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unit_price) {
		this.unitPrice = unit_price;
	}

	public TradeStatus getStatus() {
		return status;
	}

	public void setStatus(TradeStatus status) {
		this.status = status;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Set<UserStockTrade> getUserStockTrade() {
		return userStockTrade;
	}

	public void setUserStockTrade(Set<UserStockTrade> userStockTrade) {
		this.userStockTrade = userStockTrade;
	}

	public TradeSide getSide() {
		return side;
	}

	public void setSide(TradeSide side) {
		this.side = side;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
