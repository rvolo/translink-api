package com.robvolo.api.translink;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RouteMap {
	@JsonProperty("Href")
	private String href;

	public String getHref() {
		return href;
	}

	public RouteMap setHref(String href) {
		this.href = href;
		return this;
	}

	@Override
	public String toString() {
		return href;
	}
}
