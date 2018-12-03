package com.robvolo.api.translink;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

class TranslinkApiImpl implements TranslinkApi {
	private final String apiKey;
	private ObjectMapper mapper = new ObjectMapper();
	private OkHttpClient httpClient = new OkHttpClient();

	TranslinkApiImpl(String apiKey) {
		if (apiKey == null) {
			throw new NullPointerException();
		}

		this.apiKey = apiKey;
	}

	@Override
	public Stop getStopInfo(int stopNumber) throws IOException, RequestException {
		Request request = createRequestBuilder().url("http://api.translink.ca/rttiapi/v1/stops/" + stopNumber + "?apikey=" + apiKey).get().build();
		return sendRequest(request, Stop.class);
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

	private Request.Builder createRequestBuilder() {
		return new Request.Builder().addHeader("Accept", "application/json");
	}
}
