package gr.Accenture2.TradingPlatform.web.json.response;

public class UserDataResponse<T> {

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
		private final String userDataStatus;

		/**
		 * Create a {@link Status} with the specified name.
		 * 
		 * @param name the {@link Status} name.
		 */
		private Status(final String name) {
			this.userDataStatus = name;
		}

		/**
		 * Returns the {@link Status} name.
		 * 
		 * @return the name
		 */
		public String getStatus() {
			return userDataStatus;
		}
	};
	
	
	/** The status. */
	private String userDataStatus;
	
	/** The status message. */
	private String userDataStatusMessage;

	/** The item. */
	private T item;
	

	public String getUserDataStatus() {
		return userDataStatus;
	}

	public void setUserDataStatus(String userDataStatus) {
		this.userDataStatus = userDataStatus;
	}



	public String getUserDataStatusMessage() {
		return userDataStatusMessage;
	}



	public void setUserDataStatusMessage(String userDataStatusMessage) {
		this.userDataStatusMessage = userDataStatusMessage;
	}

	public UserDataResponse(String userDataStatus,
			String userDataStatusMessage) {

		this.userDataStatus = userDataStatus;
		this.userDataStatusMessage = userDataStatusMessage;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public UserDataResponse(String userDataStatus,
			String userDataStatusMessage, T item) {
		super();
		this.userDataStatus = userDataStatus;
		this.userDataStatusMessage = userDataStatusMessage;
		this.item = item;
	}

	
	
}
