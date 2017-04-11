package gr.Accenture2.TradingPlatform.core.enumaration;
/**
 * @author Billy
 * 
 * The String Constants. This enum is just for grouping them
 *
 */
public enum StringEnumeration {

	/** The string prefix that is used for error messages in the messages_(x).properties  */
	ERROR_MESSAGE("errorMessage-");

	
	private String string;

	private StringEnumeration(String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}
}
