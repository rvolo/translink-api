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
		return createNew("http://api.translink.ca", "/rttiapi/v1", api);
	}

	/**
	 * Creates a new instance of the translink api with a new base url and api key
	 *
	 * @param hostname server hostname ex. http://api.translink.ca
	 * @param apiPath  path to api base path ex. /rttiapi/v1/
	 * @param apiKey   api key from translink
	 * @return new api client
	 */
	static TranslinkApi createNew(String hostname, String apiPath, String apiKey) {
		if (hostname == null || hostname.isEmpty()) {
			throw new IllegalArgumentException("String argument for hostname is invalid");
		}
		if (apiPath == null || apiPath.isEmpty()) {
			throw new IllegalArgumentException("String argument for apiPath is invalid");
		}
		if (apiKey == null || apiKey.isEmpty()) {
			throw new IllegalArgumentException("String argument for apiKey is invalid");
		}
		return new TranslinkApiImpl(new TranslinkUrlFactory(hostname, apiPath, apiKey));
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
	Stop[] getStops(double lat, double lon) throws IOException, RequestException;

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
	Stop[] getStops(double lat, double lon, int radius) throws IOException, RequestException;

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
	Stop[] getStopsOnRoute(double lat, double lon, String route) throws IOException, RequestException;

	/**
	 * Gets the next bus estimates for a particular stop.
	 *
	 * @param stopNum stop number
	 * @return Returns schedule data if estimates are not available
	 * @throws IOException      connection error
	 * @throws RequestException error reading response
	 * @since 0.0.1
	 */
	StopEstimate[] getStopEstimate(int stopNum) throws IOException, RequestException;

	/**
	 * Gets the next bus estimates for a particular stop.
	 *
	 * @param stopNum   A five-digit stop number
	 * @param busCount  The number of buses to return
	 * @param timeFrame The search time frame in minutes
	 * @param routeNum  Search for stops specific to route
	 * @return search for stops specific to route
	 * @throws IOException      connection error
	 * @throws RequestException error reading response
	 * @since 0.0.1
	 */
	StopEstimate[] getStopEstimate(int stopNum, Integer busCount, Integer timeFrame, String routeNum) throws IOException, RequestException;

}
