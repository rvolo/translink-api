package com.robvolo.api.translink;

import okhttp3.HttpUrl;

/**
 * Build urls based on parameters
 * https://developer.translink.ca/ServicesRtti/ApiReference
 */
@SuppressWarnings("unused")
class TranslinkUrlFactory {
	private final String hostname;
	private final String apiPath;
	private final String apiKey;

	TranslinkUrlFactory(String hostname, String apiPath, String apiKey) {
		this.hostname = hostname;
		this.apiPath = apiPath;
		if (apiKey == null) {
			apiKey = "dddd";
		}
		this.apiKey = apiKey;
	}

	/**
	 * https://developer.translink.ca/ServicesRtti/ApiReference#Stops
	 */
	HttpUrl buildStops(Integer stopNum, Double latitude, Double longitude, Integer radius, String routeNum) {
		HttpUrl.Builder url;
		if (stopNum != null) {
			url = newUrlBuilder("/stops/" + stopNum);
		} else {
			url = newUrlBuilder("/stops");
		}

		if (latitude != null) {
			url.addQueryParameter("lat", String.valueOf(latitude));
		}
		if (longitude != null) {
			url.addQueryParameter("long", String.valueOf(longitude));
		}
		if (radius != null) {
			url.addQueryParameter("radius", String.valueOf(radius));
		}
		if (routeNum != null) {
			url.addQueryParameter("routeNo", routeNum);
		}

		return url.build();
	}

	/**
	 * https://developer.translink.ca/ServicesRtti/ApiReference#StopEstimates
	 */
	HttpUrl buildStopEstimate(int stopNum, Integer busCount, Integer timeFrame, String routeNum) {
		HttpUrl.Builder url = newUrlBuilder("/stops/" + stopNum + "/estimates");

		if (busCount != null) {
			url.addQueryParameter("count", String.valueOf(busCount));
		}
		if (timeFrame != null) {
			url.addQueryParameter("timeframe", String.valueOf(timeFrame));
		}
		if (routeNum != null) {
			url.addQueryParameter("routeNo", routeNum);
		}

		return url.build();
	}

	/**
	 * https://developer.translink.ca/ServicesRtti/ApiReference#Buses
	 */
	HttpUrl buildBuses(Integer busNum, Integer stopNum, String routeNum) {
		HttpUrl.Builder url;
		if (busNum != null) {
			url = newUrlBuilder("/buses/" + busNum);
		} else {
			url = newUrlBuilder("/buses");
		}

		if (stopNum != null) {
			url.addQueryParameter("stopNo", String.valueOf(stopNum));
		}
		if (routeNum != null) {
			url.addQueryParameter("routeNo", routeNum);
		}

		return url.build();
	}

	/**
	 * https://developer.translink.ca/ServicesRtti/ApiReference#Routes
	 */
	HttpUrl buildRoutes(String routeNum, Integer stopNum) {
		HttpUrl.Builder url;
		if (routeNum != null) {
			url = newUrlBuilder("/routes/" + routeNum);
		} else {
			url = newUrlBuilder("/routes");
		}

		if (stopNum != null) {
			url.addQueryParameter("stopNo", String.valueOf(stopNum));
		}

		return url.build();
	}

	/**
	 * https://developer.translink.ca/ServicesRtti/ApiReference#Status
	 */
	HttpUrl buildServiceStatus(ServiceStatus status) {
		switch (status) {
			case LOCATION:
				return newUrlBuilder("/status/location").build();
			case SCHEDULE:
				return newUrlBuilder("/status/schedule").build();
			case ALL:
				return newUrlBuilder("/status/all").build();
			default:
				throw new UnsupportedOperationException("Type:" + status + " not supported by UrlFactory");
		}
	}

	private HttpUrl.Builder newUrlBuilder(String path) {
		HttpUrl.Builder builder = HttpUrl.get(hostname).newBuilder(apiPath + path);
		if (builder != null) {
			return builder.addQueryParameter("apikey", apiKey);
		}
		throw new NullPointerException("Error creating UrlBuilder");
	}
}
