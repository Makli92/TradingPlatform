package gr.Accenture2.TradingPlatform.core.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "orders")
public class Order {
	
	/**
     * The id in database
     */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@DateTimeFormat
	private Date dateIssue;

	public Order() {
		super();
	}

	public Order(long id, Date dateIssue) {
		super();
		this.id = id;
		this.dateIssue = dateIssue;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateIssue() {
		return dateIssue;
	}

	public void setDateIssue(Date dateIssue) {
		this.dateIssue = dateIssue;
	}
	
}
