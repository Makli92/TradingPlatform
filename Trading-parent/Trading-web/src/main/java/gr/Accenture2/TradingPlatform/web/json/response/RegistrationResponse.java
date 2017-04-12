package gr.Accenture2.TradingPlatform.web.json.response;

import java.util.HashSet;
import java.util.Set;

public class RegistrationResponse {

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
		private final String registrationStatus;

		/**
		 * Create a {@link Status} with the specified name.
		 * 
		 * @param name the {@link Status} name.
		 */
		private Status(final String name) {
			this.registrationStatus = name;
		}

		/**
		 * Returns the {@link Status} name.
		 * 
		 * @return the name
		 */
		public String getStatus() {
			return registrationStatus;
		}
	};
	
	
	/** The status. */
	private String registrationStatus;
	
	/** The status message. */
	private Set registrationStatusMessages =  new HashSet();

	

	public String getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}



	public Set getRegistrationStatusMessages() {
		return registrationStatusMessages;
	}



	public void addRegistrationStatusMessage(String registrationStatusMessage) {
		this.registrationStatusMessages.add(registrationStatusMessage);

	}

	public RegistrationResponse() {

	}
	
	public RegistrationResponse(String registrationStatus,
			Set registrationStatusMessage) {

		this.registrationStatus = registrationStatus;
		this.registrationStatusMessages.add(registrationStatusMessage);
	}

}
