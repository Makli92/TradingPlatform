package gr.Accenture2.TradingPlatform.web.enumeration;

public enum RestResponseStatus {
	/**
	 * The OK status. Used in order to indicate that the specific response is a valid one.
	 */
	OK("OK"),
	/**
	 * The ERROR status. Used when there is a generated exception or logic error in specific business logic.
	 */
	ERROR("ERROR"),

	UNAUTHORIZED("UNAUTHORIZED");

	/** The name of the status - useful to use as return object. */
	private final String name;

	/**
	 * Returns the {@link Status} name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	private RestResponseStatus(String name) {
		this.name = name;
	}
};