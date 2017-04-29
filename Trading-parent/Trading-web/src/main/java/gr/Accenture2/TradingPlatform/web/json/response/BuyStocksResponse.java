package gr.Accenture2.TradingPlatform.web.json.response;

public class BuyStocksResponse<T> {

	public static enum Status {
		/**
		 * The OK status. Used in order to indicate that the specific response is a valid one.
		 */
		OK("OK"),
		/**
		 * The ERROR status. Used when there is a generated exception or logic error in specific business logic.
		 */
		NOT_OK("NOT_OK"),
		;

		/** The name of the status - useful to use as return object. */
		private final String buyStocksStatus;

		/**
		 * Create a {@link Status} with the specified name.
		 * 
		 * @param name the {@link Status} name.
		 */
		private Status(final String name) {
			this.buyStocksStatus = name;
		}

		/**
		 * Returns the {@link Status} name.
		 * 
		 * @return the name
		 */
		public String getStatus() {
			return buyStocksStatus;
		}
	};
	
	
	/** The status. */
	private String buyStocksStatus;
	
	/** The status message. */
	private String buyStocksStatusMessage;

	/** The item. */
	private T item;
	

	public String getBuyStocksStatus() {
		return buyStocksStatus;
	}

	public void setBuyStocksStatus(String buyStocksStatus) {
		this.buyStocksStatus = buyStocksStatus;
	}



	public String getBuyStocksStatusMessage() {
		return buyStocksStatusMessage;
	}



	public void setBuyStocksStatusMessage(String buyStocksStatusMessage) {
		this.buyStocksStatusMessage = buyStocksStatusMessage;
	}

	public BuyStocksResponse(String buyStocksStatus,
			String buyStocksStatusMessage) {

		this.buyStocksStatus = buyStocksStatus;
		this.buyStocksStatusMessage = buyStocksStatusMessage;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public BuyStocksResponse(String buyStocksStatus,
			String buyStocksStatusMessage, T item) {
		super();
		this.buyStocksStatus = buyStocksStatus;
		this.buyStocksStatusMessage = buyStocksStatusMessage;
		this.item = item;
	}

	
	
}
