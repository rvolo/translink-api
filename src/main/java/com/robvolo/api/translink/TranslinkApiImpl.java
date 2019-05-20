package com.robvolo.api.translink;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

class TranslinkApiImpl implements TranslinkApi {
	private final TranslinkUrlFactory urlFactory;
	private ObjectMapper mapper = new ObjectMapper();
	private OkHttpClient httpClient = new OkHttpClient();

	TranslinkApiImpl(TranslinkUrlFactory factory) {
		this.urlFactory = factory;
	}

	@Override
	public Stop getStopInfo(int stopNumber) throws IOException, RequestException {
		return sendRequest(urlFactory.buildStops(stopNumber, null, null, null, null), Stop.class);
	}

	@Override
	public Stop[] getStops(double lat, double lon) throws IOException, RequestException {
		return sendRequest(urlFactory.buildStops(null, lat, lon, null, null), Stop[].class);
	}

	@Override
	public Stop[] getStops(double lat, double lon, int radius) throws IOException, RequestException {
		return sendRequest(urlFactory.buildStops(null, lat, lon, radius, null), Stop[].class);
	}

	@Override
	public Stop[] getStopsOnRoute(double lat, double lon, String route) throws IOException, RequestException {
		return sendRequest(urlFactory.buildStops(null, lat, lon, null, route), Stop[].class);
	}

	@Override
	public StopEstimate[] getStopEstimate(int stopNum) throws IOException, RequestException {
		return sendRequest(urlFactory.buildStopEstimate(stopNum, null, null, null), StopEstimate[].class);
	}

	@Override
	public StopEstimate[] getStopEstimate(int stopNum, Integer busCount, Integer timeFrame, String routeNum) throws IOException, RequestException {
		return sendRequest(urlFactory.buildStopEstimate(stopNum, busCount, timeFrame, routeNum), StopEstimate[].class);
	}

	private <T> T sendRequest(HttpUrl url, Class<T> pojo) throws IOException, RequestException {
		return sendRequest(new Request.Builder().addHeader("Accept", "application/json").url(url).get().build(), pojo);
	}

	private <T> T sendRequest(Request request, Class<T> pojo) throws IOException, RequestException {
		Response response = httpClient.newCall(request).execute();

		if (response.body() == null) {
			throw new NullPointerException();
		}

		String responseString = response.body().string();
		try {
			return mapper.readValue(responseString, pojo);
		} catch (JsonParseException | JsonMappingException jsonException) {
			throw mapper.readValue(responseString, RequestException.class);
		}
	}
}
