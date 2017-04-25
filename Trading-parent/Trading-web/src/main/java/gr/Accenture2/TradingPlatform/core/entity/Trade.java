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
	private Date trade_date;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TradeSide side;
	
	private double orderPriceWithFeeTaxes;
	
	private double orderPriceWithoutFeeTaxes;

	private double unit_price;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TradeStatus status = TradeStatus.COMPLETE;
	
	private int quantity;
	
	@OneToMany(mappedBy = "trade", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
	private Set<UserStockTrade> userStockTrade;

	public long getId() {
		return id;
	}

	@PrePersist
	void preInserttrade_date() {
		this.setTrade_date(new Date());
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public Date getTrade_date() {
		return trade_date;
	}

	public void setTrade_date(Date trade_date) {
		this.trade_date = trade_date;
	}

	public double getOrderPriceWithFeeTaxes() {
		return orderPriceWithFeeTaxes;
	}

	public void setOrderPriceWithFeeTaxes(double orderPriceWithFeeTaxes) {
		this.orderPriceWithFeeTaxes = orderPriceWithFeeTaxes;
	}

	public double getOrderPriceWithoutFeeTaxes() {
		return orderPriceWithoutFeeTaxes;
	}

	public void setOrderPriceWithoutFeeTaxes(double orderPriceWithoutFeeTaxes) {
		this.orderPriceWithoutFeeTaxes = orderPriceWithoutFeeTaxes;
	}

	public double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
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
	
	
	
	
	
	
}
