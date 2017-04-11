package gr.Accenture2.TradingPlatform.web.json.response;

/**
 * The Class GenericResponse is the generic class to be used for responses. Instantiate the class with the required class.
 * 
 * @param <T> the generic type
 */
public class GenericResponse<T> extends GenericRestResponse {
	/** The item. */
	private T item;

	/**
	 * Sets the item.
	 * 
	 * @param item the item
	 */
	public void setItem(final T item) {
		this.item = item;
	}

	/**
	 * Gets the item.
	 * 
	 * @return the item
	 */
	public T getItem() {
		return item;
	}

}
