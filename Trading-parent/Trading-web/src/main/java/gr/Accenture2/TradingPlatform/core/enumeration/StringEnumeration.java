package gr.Accenture2.TradingPlatform.core.enumeration;
/**
 * @author Billy
 * 
 * The String Constants. This enum is just for grouping them
 *
 */
public enum StringEnumeration {

	/** String "1"  */
	ONE("1"),
	/** role User  */
	USER("User");
	
	private String string;

	private StringEnumeration(String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}
}
