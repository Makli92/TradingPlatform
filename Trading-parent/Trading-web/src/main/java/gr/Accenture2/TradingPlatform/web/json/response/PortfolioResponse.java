package gr.Accenture2.TradingPlatform.web.json.response;

public class PortfolioResponse<T> {

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
		private final String portfolioStatus;

		/**
		 * Create a {@link Status} with the specified name.
		 * 
		 * @param name the {@link Status} name.
		 */
		private Status(final String name) {
			this.portfolioStatus = name;
		}

		/**
		 * Returns the {@link Status} name.
		 * 
		 * @return the name
		 */
		public String getStatus() {
			return portfolioStatus;
		}
	};
	
	/** The status. */
	private String portfolioStatus;
	
	/** The status message. */
	private String portfolioStatusMessage;

	/** The item. */
	private T item;

	public PortfolioResponse(String portfolioStatus, String portfolioStatusMessage, T item) {
		super();
		this.portfolioStatus = portfolioStatus;
		this.portfolioStatusMessage = portfolioStatusMessage;
		this.item = item;
	}

	public String getPortfolioStatus() {
		return portfolioStatus;
	}

	public void setPortfolioStatus(String portfolioStatus) {
		this.portfolioStatus = portfolioStatus;
	}

	public String getPortfolioStatusMessage() {
		return portfolioStatusMessage;
	}

	public void setPortfolioStatusMessage(String portfolioStatusMessage) {
		this.portfolioStatusMessage = portfolioStatusMessage;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
}
