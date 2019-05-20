package com.robvolo.api.translink;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Schedule {
	@JsonProperty("Pattern")
	private String pattern;
	@JsonProperty("Destination")
	private String destination;
	@JsonProperty("ExpectedLeaveTime")
	private String expectedLeaveTime;
	@JsonProperty("ExpectedCountdown")
	private Long expectedCountdown;
	@JsonProperty("ScheduleStatus")
	private String scheduleStatus;
	@JsonProperty("CancelledTrip")
	private Boolean cancelledTrip;
	@JsonProperty("CancelledStop")
	private Boolean cancelledStop;
	@JsonProperty("AddedTrip")
	private Boolean addedTrip;
	@JsonProperty("AddedStop")
	private Boolean addedStop;
	@JsonProperty("LastUpdate")
	private String lastUpdate;

	/**
	 * @return The expected departure time in minutes
	 */
	public String getPattern() {
		return pattern;
	}

	public Schedule setPattern(String pattern) {
		this.pattern = pattern;
		return this;
	}

	/**
	 * @return The expected departure time in minutes
	 */
	public String getDestination() {
		return destination;
	}

	public Schedule setDestination(String destination) {
		this.destination = destination;
		return this;
	}

	/**
	 * @return The expected departure time in minutes
	 */
	public String getExpectedLeaveTime() {
		return expectedLeaveTime;
	}

	public Schedule setExpectedLeaveTime(String expectedLeaveTime) {
		this.expectedLeaveTime = expectedLeaveTime;
		return this;
	}

	/**
	 * @return The expected departure time in minutes
	 */
	public Long getExpectedCountdown() {
		return expectedCountdown;
	}

	public Schedule setExpectedCountdown(Long expectedCountdown) {
		this.expectedCountdown = expectedCountdown;
		return this;
	}

	/**
	 * The status of the trip.
	 * <p>
	 * * indicates scheduled time
	 * - indicates delay
	 * + indicates bus is running ahead of schedule
	 */
	public String getScheduleStatus() {
		return scheduleStatus;
	}

	public Schedule setScheduleStatus(String scheduleStatus) {
		this.scheduleStatus = scheduleStatus;
		return this;
	}

	/**
	 * @return Indicates if trip is cancelled
	 */
	public Boolean getCancelledTrip() {
		return cancelledTrip;
	}

	public Schedule setCancelledTrip(Boolean cancelledTrip) {
		this.cancelledTrip = cancelledTrip;
		return this;
	}

	/**
	 * @return Indicates if stop is cancelled
	 */
	public Boolean getCancelledStop() {
		return cancelledStop;
	}

	public Schedule setCancelledStop(Boolean cancelledStop) {
		this.cancelledStop = cancelledStop;
		return this;
	}

	/**
	 * @return Indicates if trip is added
	 */
	public Boolean getAddedTrip() {
		return addedTrip;
	}

	public Schedule setAddedTrip(Boolean addedTrip) {
		this.addedTrip = addedTrip;
		return this;
	}

	/**
	 * @return Indicates if stop is added
	 */
	public Boolean getAddedStop() {
		return addedStop;
	}

	public Schedule setAddedStop(Boolean addedStop) {
		this.addedStop = addedStop;
		return this;
	}

	/**
	 * @return The last updated time of the trip
	 */
	public String getLastUpdate() {
		return lastUpdate;
	}

	public Schedule setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
		return this;
	}

	@Override
	public String toString() {
		return "Schedule{" +
				"pattern='" + pattern + '\'' +
				", destination='" + destination + '\'' +
				", expectedLeaveTime='" + expectedLeaveTime + '\'' +
				", expectedCountdown=" + expectedCountdown +
				", scheduleStatus='" + scheduleStatus + '\'' +
				", cancelledTrip=" + cancelledTrip +
				", cancelledStop=" + cancelledStop +
				", addedTrip=" + addedTrip +
				", addedStop=" + addedStop +
				", lastUpdate='" + lastUpdate + '\'' +
				'}';
	}
}
