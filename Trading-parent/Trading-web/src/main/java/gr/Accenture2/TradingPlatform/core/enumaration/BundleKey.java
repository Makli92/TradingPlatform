package gr.Accenture2.TradingPlatform.core.enumaration;
/**
 * @author Billy
 * 
 * The String Constants. This enum is just for grouping them
 *
 */
public enum BundleKey {

	/** The string prefix that is used for error messages in the messages_(x).properties  */
	ERROR_MESSAGE("errorMessage-"),
	
	FORGOT_MESSAGE("forgot-message");

	
	private String key;

	private BundleKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
