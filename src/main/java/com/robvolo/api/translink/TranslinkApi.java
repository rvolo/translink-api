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
	 * Create a new instance of the translink api
	 *
	 * @param api api key from translink
	 * @return new api client
	 */
	static TranslinkApi createNew(String api) {
		return new TranslinkApiImpl(api);
	}

	/**
	 * Stops are locations where buses provide scheduled service.
	 *
	 * @param stopNumber A five-digit stop number
	 * @return stop info
	 * @throws IOException      connection error
	 * @throws RequestException error reading response
	 * @since 0.0.1
	 */
	Stop getStopInfo(int stopNumber) throws IOException, RequestException;


}
