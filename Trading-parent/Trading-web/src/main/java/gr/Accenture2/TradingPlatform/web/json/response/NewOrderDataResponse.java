package gr.Accenture2.TradingPlatform.web.json.response;

public class NewOrderDataResponse<T> {

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
		private final String newOrderDataStatus;

		/**
		 * Create a {@link Status} with the specified name.
		 * 
		 * @param name the {@link Status} name.
		 */
		private Status(final String name) {
			this.newOrderDataStatus = name;
		}

		/**
		 * Returns the {@link Status} name.
		 * 
		 * @return the name
		 */
		public String getStatus() {
			return newOrderDataStatus;
		}
	};
	
	
	/** The status. */
	private String newOrderDataStatus;
	
	/** The status message. */
	private String newOrderDataStatusMessage;

	/** The item. */
	private T item;
	

	public String getNewOrderDataStatus() {
		return newOrderDataStatus;
	}

	public void setNewOrderDataStatus(String newOrderDataStatus) {
		this.newOrderDataStatus = newOrderDataStatus;
	}



	public String getNewOrderDataStatusMessage() {
		return newOrderDataStatusMessage;
	}



	public void setNewOrderDataStatusMessage(String newOrderDataStatusMessage) {
		this.newOrderDataStatusMessage = newOrderDataStatusMessage;
	}

	public NewOrderDataResponse(String newOrderDataStatus,
			String newOrderDataStatusMessage) {

		this.newOrderDataStatus = newOrderDataStatus;
		this.newOrderDataStatusMessage = newOrderDataStatusMessage;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public NewOrderDataResponse(String newOrderDataStatus,
			String newOrderDataStatusMessage, T item) {
		super();
		this.newOrderDataStatus = newOrderDataStatus;
		this.newOrderDataStatusMessage = newOrderDataStatusMessage;
		this.item = item;
	}

	
	
}
