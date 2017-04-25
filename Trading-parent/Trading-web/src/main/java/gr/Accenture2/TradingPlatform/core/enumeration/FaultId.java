package gr.Accenture2.TradingPlatform.core.enumeration;

/**
 * The Enum FaultId contains unique fault id per business case/action. The idea is to group under this id, all errors being thrown for a specific
 * service method. Keep in mind that {@link FaultCode} proposes a specific range of ids per fault code.
 */
public enum FaultId {
	/** The general error, this fault indicates that the error cause should not be communicated to the users. A generic error should appear. */
	GENERAL_ERROR(1L),
	
	/**
	 * The authentication error
	 */
	AUTHENTICATION_ERROR(2L),
	
	
	/**
	 * The requested stocks for purchase are not available any more
	 * 
	 */
	UNPURCHASED_STOCKS_NOT_AVAILABLE(3L),
	
	/**
	 * Customer has not enough cash balance
	 * 
	 */
	NOT_ENOUPH_BALANCE(4L);
	
	/** The id reference. */
	private final Long idRef;


	/**
	 * Instantiates a new {@link FaultId}.
	 * 
	 * @param idRef the id ref
	 * @param faultCode the fault code
	 */
	private FaultId(final Long idRef) {
		this.idRef = idRef;

	}

	/**
	 * Gets the {@link FaultId} for the given case.
	 * 
	 * @return the id reference
	 */
	public Long getIdRef() {
		return idRef;
	}

	/**
	 * Gets the {@link FaultId} as string.
	 * 
	 * @return the {@link FaultId} as string
	 */
	public String getIdRefToString() {
		return Long.toString(idRef);
	}

}