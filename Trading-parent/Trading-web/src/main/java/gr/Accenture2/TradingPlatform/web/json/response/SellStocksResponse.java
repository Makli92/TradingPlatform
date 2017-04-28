package gr.Accenture2.TradingPlatform.web.json.response;

public class SellStocksResponse<T> {

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
		private final String sellStocksStatus;

		/**
		 * Create a {@link Status} with the specified name.
		 * 
		 * @param name the {@link Status} name.
		 */
		private Status(final String name) {
			this.sellStocksStatus = name;
		}

		/**
		 * Returns the {@link Status} name.
		 * 
		 * @return the name
		 */
		public String getStatus() {
			return sellStocksStatus;
		}
	};
	
	
	/** The status. */
	private String sellStocksStatus;
	
	/** The status message. */
	private String sellStocksStatusMessage;

	/** The item. */
	private T item;
	

	public String getsellStocksStatus() {
		return sellStocksStatus;
	}

	public void setsellStocksStatus(String sellStocksStatus) {
		this.sellStocksStatus = sellStocksStatus;
	}



	public String getsellStocksStatusMessage() {
		return sellStocksStatusMessage;
	}



	public void setsellStocksStatusMessage(String sellStocksStatusMessage) {
		this.sellStocksStatusMessage = sellStocksStatusMessage;
	}

	public SellStocksResponse(String sellStocksStatus,
			String sellStocksStatusMessage) {

		this.sellStocksStatus = sellStocksStatus;
		this.sellStocksStatusMessage = sellStocksStatusMessage;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public SellStocksResponse(String sellStocksStatus,
			String sellStocksStatusMessage, T item) {
		super();
		this.sellStocksStatus = sellStocksStatus;
		this.sellStocksStatusMessage = sellStocksStatusMessage;
		this.item = item;
	}

	
	
}
