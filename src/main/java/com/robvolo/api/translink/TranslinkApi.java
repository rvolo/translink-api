package com.robvolo.api.translink;

import java.io.IOException;

/**
 * Interface for all the translink api requests
 * <p>
 * Ref: https://developer.translink.ca/ServicesRtti/ApiReference
 *
 * @since 0.0.1
 */
public interface TranslinkApi {
	/**
	 * Create a new instance of the translink api using the v1 url
	 *
	 * @param api api key from translink
	 * @return new api client
	 */
	static TranslinkApi createNew(String api) {
		return createNew("http://api.translink.ca/rttiapi/v1/", api);
	}

	/**
	 * Creates a new instance of the translink api with a new base url and api key
	 *
	 * @param baseUrl base url path ex: http://api.translink.ca/rttiapi/v1/
	 * @param api     api key from translink
	 * @return new api client
	 */
	static TranslinkApi createNew(String baseUrl, String api) {
		if (baseUrl == null || baseUrl.isEmpty()) {
			throw new IllegalArgumentException("baseUrl cannot be a blank string");
		}
		if (api == null || api.isEmpty()) {
			throw new IllegalArgumentException("Api key cannot be a ");
		}
		return new TranslinkApiImpl(baseUrl, api);
	}

	/**
	 * Stops are locations where buses provide scheduled service.
	 *
	 * @param stopNumber A five-digit stop number
	 * @return Bus stop info
	 * @throws IOException      connection error
	 * @throws RequestException error reading response
	 * @since 0.0.1
	 */
	Stop getStopInfo(int stopNumber) throws IOException, RequestException;

	/**
	 * Returns stops near latitude/longitude coordinates
	 *
	 * @param lat latitude
	 * @param lon longitude
	 * @return list of stops
	 * @throws IOException      connection error
	 * @throws RequestException error reading response
	 * @since 0.0.1
	 */
	Stop[] getStops(float lat, float lon) throws IOException, RequestException;

	/**
	 * Returns stops near latitude/longitude coordinates in a certain radius
	 *
	 * @param lat    latitude
	 * @param lon    longitude
	 * @param radius distance from lat & long, maximum 2000
	 * @return list of stops
	 * @throws IOException      connection error
	 * @throws RequestException error reading response
	 * @since 0.0.1
	 */
	Stop[] getStops(float lat, float lon, int radius) throws IOException, RequestException;

	/**
	 * Returns stops near latitude/longitude coordinates filtered by the current route number
	 *
	 * @param lat   latitude
	 * @param lon   longitude
	 * @param route filter by route number
	 * @return list of stops
	 * @throws IOException      connection error
	 * @throws RequestException error reading response
	 * @since 0.0.1
	 */
	Stop[] getStopsOnRoute(float lat, float lon, int route) throws IOException, RequestException;
}
