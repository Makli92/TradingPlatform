package gr.Accenture2.TradingPlatform.core.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;




	@Entity
	@Table(name = "stocks")
	public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long stock_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", columnDefinition = "DATETIME")
	private Date creation_date;
	
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	  private Set<Company> company;

	public long getStock_id() {
		return stock_id;
	}

	public void setStock_id(long stock_id) {
		this.stock_id = stock_id;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	
	

}
