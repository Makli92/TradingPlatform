package gr.Accenture2.TradingPlatform.core.entity;

import gr.Accenture2.TradingPlatform.core.enumeration.FaultId;

import java.io.Serializable;



/**
 * The Class Fault. This is an immutable object that acts as a fault carrier used to communicate faults 
 * across the platform. This object's use is kept for internal use and not broadcasted.
 */
public class Fault implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8687873931069295820L;
	
	/** The fault id. The object that indicates the fault cause. */
	private final FaultId faultId;

	/**
	 * Instantiates a new fault.
	 * 
	 * @param faultId the fault id
	 */
	public Fault(final FaultId faultId) {
		super();
		this.faultId = faultId;
	}

	/**
	 * Gets the fault id.
	 * 
	 * @return the fault id
	 */
	public FaultId getFaultId() {
		return faultId;
	}
}
