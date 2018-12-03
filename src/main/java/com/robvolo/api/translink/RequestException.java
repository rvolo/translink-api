package com.robvolo.api.translink;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Generic server error response object
 *
 * @since 0.0.1
 */
public class RequestException extends Exception {
	@JsonProperty("Code")
	private String errorCode;
	@JsonProperty("Message")
	private String message;

	@JsonProperty("Code")
	public String getErrorCode() {
		return errorCode;
	}

	@JsonProperty("Code")
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@JsonProperty("Message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("Message")
	public void setMessage(String message) {
		this.message = message;
	}
}
