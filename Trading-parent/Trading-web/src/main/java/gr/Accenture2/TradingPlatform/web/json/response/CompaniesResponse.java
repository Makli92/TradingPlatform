package gr.Accenture2.TradingPlatform.web.json.response;

public class CompaniesResponse<T> {

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
		private final String companiesStatus;

		/**
		 * Create a {@link Status} with the specified name.
		 * 
		 * @param name the {@link Status} name.
		 */
		private Status(final String name) {
			this.companiesStatus = name;
		}

		/**
		 * Returns the {@link Status} name.
		 * 
		 * @return the name
		 */
		public String getStatus() {
			return companiesStatus;
		}
	};
	
	
	/** The status. */
	private String companiesStatus;
	
	/** The status message. */
	private String companiesStatusMessage;

	/** The item. */
	private T item;
	

	public String getCompaniesStatus() {
		return companiesStatus;
	}

	public void setCompaniesStatus(String companiesStatus) {
		this.companiesStatus = companiesStatus;
	}



	public String getCompaniesStatusMessage() {
		return companiesStatusMessage;
	}



	public void setCompaniesStatusMessage(String companiesStatusMessage) {
		this.companiesStatusMessage = companiesStatusMessage;
	}

	public CompaniesResponse(String companiesStatus,
			String companiesStatusMessage) {

		this.companiesStatus = companiesStatus;
		this.companiesStatusMessage = companiesStatusMessage;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public CompaniesResponse(String companiesStatus,
			String companiesStatusMessage, T item) {
		super();
		this.companiesStatus = companiesStatus;
		this.companiesStatusMessage = companiesStatusMessage;
		this.item = item;
	}

	
	
}
