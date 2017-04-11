package gr.Accenture2.TradingPlatform.web.json.response;

public class AuthenticationResponse {

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
		private final String authenticationStatus;

		/**
		 * Create a {@link Status} with the specified name.
		 * 
		 * @param name the {@link Status} name.
		 */
		private Status(final String name) {
			this.authenticationStatus = name;
		}

		/**
		 * Returns the {@link Status} name.
		 * 
		 * @return the name
		 */
		public String getStatus() {
			return authenticationStatus;
		}
	};
	
	
	/** The status. */
	private String authenticationStatus;
	
	/** The status message. */
	private String authenticationStatusMessage;

	

	public String getAuthenticationStatus() {
		return authenticationStatus;
	}

	public void setAuthenticationStatus(String authenticationStatus) {
		this.authenticationStatus = authenticationStatus;
	}



	public String getAuthenticationStatusMessage() {
		return authenticationStatusMessage;
	}



	public void setAuthenticationStatusMessage(String authenticationStatusMessage) {
		this.authenticationStatusMessage = authenticationStatusMessage;
	}

	public AuthenticationResponse(String authenticationStatus,
			String authenticationStatusMessage) {

		this.authenticationStatus = authenticationStatus;
		this.authenticationStatusMessage = authenticationStatusMessage;
	}

}
