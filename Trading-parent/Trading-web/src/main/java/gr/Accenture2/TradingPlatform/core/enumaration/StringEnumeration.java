package gr.Accenture2.TradingPlatform.core.enumaration;
/**
 * @author Billy
 * 
 * The String Constants. This enum is just for grouping them
 *
 */
public enum StringEnumeration {

	/** String "1"  */
	ONE("1");

	
	private String string;

	private StringEnumeration(String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}
}
