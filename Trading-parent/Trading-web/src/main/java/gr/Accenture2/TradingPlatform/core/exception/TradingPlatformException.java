package gr.Accenture2.TradingPlatform.core.exception;

import gr.Accenture2.TradingPlatform.core.entity.Fault;
import gr.Accenture2.TradingPlatform.core.enumaration.FaultId;

/**
 * @author Billy
 * 
 * The general exception for Trading Platform
 *
 */
public class TradingPlatformException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1511466712717976411L;
	/**
	 * The fault. This class will give enable us to carry more specific information about the cause of this exception in more robust way than a
	 * message property.
	 */
	private Fault fault = new Fault(FaultId.AUTHENTICATION_ERROR);

	public Fault getFault() {
		return fault;
	}

	public void setFault(Fault fault) {
		this.fault = fault;
	}
	
}
