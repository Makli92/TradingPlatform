package gr.Accenture2.TradingPlatform.web.json.response;

public class TradeViewResponse<T> {
	
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
		private final String tradeViewStatus;

		/**
		 * Create a {@link Status} with the specified name.
		 * 
		 * @param name the {@link Status} name.
		 */
		private Status(final String name) {
			this.tradeViewStatus = name;
		}

		/**
		 * Returns the {@link Status} name.
		 * 
		 * @return the name
		 */
		public String getStatus() {
			return tradeViewStatus;
		}
	};
	
	/** The status. */
	private String tradeViewStatus;
	
	/** The status message. */
	private String tradeViewStatusMessage;

	/** The item. */
	private T item;

	public TradeViewResponse(String tradeViewStatus, String tradeViewStatusMessage, T item) {
		super();
		this.tradeViewStatus = tradeViewStatus;
		this.tradeViewStatusMessage = tradeViewStatusMessage;
		this.item = item;
	}

	public String getTradeViewStatus() {
		return tradeViewStatus;
	}

	public void setTradeViewStatus(String tradeViewStatus) {
		this.tradeViewStatus = tradeViewStatus;
	}

	public String getTradeViewStatusMessage() {
		return tradeViewStatusMessage;
	}

	public void setTradeViewStatusMessage(String tradeViewStatusMessage) {
		this.tradeViewStatusMessage = tradeViewStatusMessage;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
	
}
