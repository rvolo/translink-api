package com.robvolo.api.translink;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Stop information
 * https://developer.translink.ca/ServicesRtti/ApiReference#Stops
 *
 * @since 0.0.1
 */
public class Stop {
	@JsonProperty("StopNo")
	private Integer stopNo;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("BayNo")
	private String bayNo;
	@JsonProperty("City")
	private String city;
	@JsonProperty("OnStreet")
	private String onStreet;
	@JsonProperty("AtStreet")
	private String atStreet;
	@JsonProperty("Latitude")
	private Double latitude;
	@JsonProperty("Longitude")
	private Double longitude;
	@JsonProperty("WheelchairAccess")
	private Long wheelchairAccess;
	@JsonProperty("Distance")
	private Long distance;
	@JsonProperty("Routes")
	private String routes;

	/**
	 * @return The 5-digit stop number
	 */
	public Integer getStopNo() {
		return stopNo;
	}

	public Stop setStopNo(Integer stopNo) {
		this.stopNo = stopNo;
		return this;
	}

	/**
	 * @return The stop name
	 */
	public String getName() {
		return name;
	}

	public Stop setName(String name) {
		this.name = name.trim();
		return this;
	}

	/**
	 * @return The bay number, if applicable
	 */
	public String getBayNo() {
		return bayNo;
	}

	public Stop setBayNo(String bayNo) {
		this.bayNo = bayNo.trim();
		return this;
	}

	/**
	 * @return The city in which the stop is located
	 */
	public String getCity() {
		return city;
	}

	public Stop setCity(String city) {
		this.city = city.trim();
		return this;
	}

	/**
	 * @return The street name the stop is located on
	 */
	public String getOnStreet() {
		return onStreet;
	}

	public Stop setOnStreet(String onStreet) {
		this.onStreet = onStreet.trim();
		return this;
	}

	/**
	 * @return The intersecting street of the stop
	 */
	public String getAtStreet() {
		return atStreet;
	}

	public Stop setAtStreet(String atStreet) {
		this.atStreet = atStreet.trim();
		return this;
	}

	/**
	 * @return The latitude of the stop
	 */
	public Double getLatitude() {
		return latitude;
	}

	public Stop setLatitude(Double latitude) {
		this.latitude = latitude;
		return this;
	}

	/**
	 * @return The longitude of the stop
	 */
	public Double getLongitude() {
		return longitude;
	}

	public Stop setLongitude(Double longitude) {
		this.longitude = longitude;
		return this;
	}

	/**
	 * @return Specifies wheelchair accessible stop. 1 indicates stop is wheelchair accessible
	 */
	public Long getWheelchairAccess() {
		return wheelchairAccess;
	}

	public Stop setWheelchairAccess(Long wheelchairAccess) {
		this.wheelchairAccess = wheelchairAccess;
		return this;
	}

	/**
	 * @return Distance away from the search location
	 */
	public Long getDistance() {
		return distance;
	}

	public Stop setDistance(Long distance) {
		this.distance = distance;
		return this;
	}

	/**
	 * @return The list of routes that the stop services
	 */
	public String getRoutes() {
		return routes;
	}

	public Stop setRoutes(String routes) {
		this.routes = routes.trim();
		return this;
	}

	@Override
	public String toString() {
		return "Stop{" +
				"stopNo=" + stopNo +
				", name='" + name + '\'' +
				", bayNo='" + bayNo + '\'' +
				", city='" + city + '\'' +
				", onStreet='" + onStreet + '\'' +
				", atStreet='" + atStreet + '\'' +
				", latitude=" + latitude +
				", longitude=" + longitude +
				", wheelchairAccess=" + wheelchairAccess +
				", distance=" + distance +
				", routes='" + routes + '\'' +
				'}';
	}
}