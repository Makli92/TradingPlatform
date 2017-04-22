package gr.Accenture2.TradingPlatform.core.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long company_id;
	
	@Column(name = "name", nullable = false)
    private String name;
	
	@OneToMany(mappedBy = "companies")
	 @JoinTable(name = "Stock_price", 
		joinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id")
		
)
	private Set<Stock_price> stock_price;

	public long getCompany_id() {
		return company_id;
	}

	public void setCompany_id(long company_id) {
		this.company_id = company_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
