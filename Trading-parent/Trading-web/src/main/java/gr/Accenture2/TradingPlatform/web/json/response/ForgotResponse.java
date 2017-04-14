package gr.Accenture2.TradingPlatform.web.json.response;

public class ForgotResponse {

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
		private final String forgotStatus;

		/**
		 * Create a {@link Status} with the specified name.
		 * 
		 * @param name the {@link Status} name.
		 */
		private Status(final String name) {
			this.forgotStatus = name;
		}

		/**
		 * Returns the {@link Status} name.
		 * 
		 * @return the name
		 */
		public String getStatus() {
			return forgotStatus;
		}
	};
	
	
	/** The status. */
	private String forgotStatus;
	
	/** The status message. */
	private String forgotStatusMessage;

	

	public String getForgotStatus() {
		return forgotStatus;
	}

	public void setForgotStatus(String forgotStatus) {
		this.forgotStatus = forgotStatus;
	}



	public String getForgotStatusMessage() {
		return forgotStatusMessage;
	}



	public void setForgotStatusMessage(String forgotStatusMessage) {
		this.forgotStatusMessage = forgotStatusMessage;
	}

	public ForgotResponse(String forgotStatus,
			String forgotStatusMessage) {

		this.forgotStatus = forgotStatus;
		this.forgotStatusMessage = forgotStatusMessage;
	}

}
