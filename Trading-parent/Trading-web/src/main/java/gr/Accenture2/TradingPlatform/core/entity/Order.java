package gr.Accenture2.TradingPlatform.core.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	/**
     * The id in database
     */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	public Order() {
		super();
	}

	public Order(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
