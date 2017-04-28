package gr.Accenture2.TradingPlatform.core.enumeration;

public enum TradeSide {
	
	BUY( 0.5f / 100 , 0),
	SELL(0.5f  / 100 ,3f);
	
	public float getTaxes() {
		return taxes;
	}

	public void setTaxes(float taxes) {
		this.taxes = taxes;
	}

	public float getFees() {
		return fees;
	}

	public void setFees(float fees) {
		this.fees = fees;
	}

	private Float taxes;
	
	private Float fees;

	private TradeSide(float taxes, float fees) {
		this.taxes = taxes;
		this.fees = fees;
	}
	

}
