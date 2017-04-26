package gr.Accenture2.TradingPlatform.core.exception;

import gr.Accenture2.TradingPlatform.core.entity.Fault;
import gr.Accenture2.TradingPlatform.core.enumeration.FaultId;

/**
 * @author Billy
 *
 * The exception that is thrown when an authentication error occurs
 *
 */
public class TradingPlatformTradeException extends TradingPlatformException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1904997241352342564L;

	public TradingPlatformTradeException() {
		super();
		this.setFault(new Fault(FaultId.AUTHENTICATION_ERROR));
	}
	
	
}
