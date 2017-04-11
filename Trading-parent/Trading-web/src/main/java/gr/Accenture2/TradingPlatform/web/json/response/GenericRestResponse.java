package gr.Accenture2.TradingPlatform.web.json.response;

public class GenericRestResponse {
	
	/** The status. */
	private String responseStatus;

	/** The status message. */
	private String responseStatusMessage;

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getResponseStatusMessage() {
		return responseStatusMessage;
	}

	public void setResponseStatusMessage(String responseStatusMessage) {
		this.responseStatusMessage = responseStatusMessage;
	}


}
