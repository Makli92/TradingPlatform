package gr.Accenture2.TradingPlatform.web.json.entity;

public class ApiLastTrades {

	Long id;
	
	Float price;
	
	int quantity;

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ApiLastTrades(Long id , Float price, int quantity) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
