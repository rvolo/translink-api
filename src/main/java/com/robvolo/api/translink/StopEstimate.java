package com.robvolo.api.translink;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class StopEstimate {
	@JsonProperty("RouteNo")
	private String routeNo;
	@JsonProperty("RouteName")
	private String routeName;
	@JsonProperty("Direction")
	private String direction;
	@JsonProperty("RouteMap")
	private RouteMap routeMap;
	@JsonProperty("Schedules")
	private List<Schedule> schedules = new ArrayList<>();

	public String getRouteNo() {
		return routeNo;
	}

	public String getRouteName() {
		return routeName;
	}

	public String getDirection() {
		return direction;
	}

	public RouteMap getRouteMap() {
		return routeMap;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	@Override
	public String toString() {
		return "StopEstimate{" +
				"routeNo='" + routeNo + '\'' +
				", routeName='" + routeName + '\'' +
				", direction='" + direction + '\'' +
				", routeMap=" + routeMap +
				", schedules=" + schedules +
				'}';
	}
}
