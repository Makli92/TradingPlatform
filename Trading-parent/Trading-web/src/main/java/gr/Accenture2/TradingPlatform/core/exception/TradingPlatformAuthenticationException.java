package gr.Accenture2.TradingPlatform.core.exception;

import gr.Accenture2.TradingPlatform.core.entity.Fault;
import gr.Accenture2.TradingPlatform.core.enumaration.FaultId;

/**
 * @author Billy
 *
 * The exception that is thrown when an authentication error occurs
 *
 */
public class TradingPlatformAuthenticationException extends TradingPlatformException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1904997241352342564L;

	public TradingPlatformAuthenticationException() {
		super();
		this.setFault(new Fault(FaultId.AUTHENTICATION_ERROR));
	}
	
	
}
