package com.cleartrip.pojo;

import java.util.HashMap;

public class ConferenceRoom {
	private String building;
	private Integer floor;
	private String conferenceId;
	private Integer capacity;
//	Time vs User id
	private HashMap<Integer, String> timeSlots = new HashMap<>();

	public ConferenceRoom(String building, Integer floor, String conferenceId) {
		this.building = building;
		this.floor = floor;
		this.conferenceId = conferenceId;
	}

	public ConferenceRoom(String building, Integer floor, String conferenceId, Integer capacity) {
		this.building = building;
		this.floor = floor;
		this.conferenceId = conferenceId;
		this.capacity = capacity;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public String getConferenceId() {
		return conferenceId;
	}

	public void setConferenceId(String conferenceId) {
		this.conferenceId = conferenceId;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public HashMap<Integer, String> getTimeSlots() {
		return timeSlots;
	}

	public void setTimeSlots(HashMap<Integer, String> timeSlots) {
		this.timeSlots = timeSlots;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ConferenceRoom that = (ConferenceRoom) o;

		if (!building.equals(that.building)) return false;
		if (!floor.equals(that.floor)) return false;
		return conferenceId.equals(that.conferenceId);
	}

	@Override
	public int hashCode() {
		int result = building.hashCode();
		result = 31 * result + floor.hashCode();
		result = 31 * result + conferenceId.hashCode();
		return result;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("ConferenceRoom{");
		sb.append("building='").append(building).append('\'');
		sb.append(", floor=").append(floor);
		sb.append(", conferenceId='").append(conferenceId).append('\'');
		sb.append(", capacity=").append(capacity);
		sb.append(", timeSlots=").append(timeSlots);
		sb.append('}');
		return sb.toString();
	}
}
