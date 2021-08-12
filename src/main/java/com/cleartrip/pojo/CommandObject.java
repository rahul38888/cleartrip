package com.cleartrip.pojo;

import java.util.Set;

public class CommandObject {

	String primaryCommand;
	String secCommand;
	Building building;
	Floor floor;
	ConferenceRoom room;
	BookingRequest bookingRequest;

	public Building getBuilding() {
		return building;
	}

	public String getPrimaryCommand() {
		return primaryCommand;
	}

	public void setPrimaryCommand(String primaryCommand) {
		this.primaryCommand = primaryCommand;
	}

	public String getSecCommand() {
		return secCommand;
	}

	public void setSecCommand(String secCommand) {
		this.secCommand = secCommand;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public ConferenceRoom getRoom() {
		return room;
	}

	public void setRoom(ConferenceRoom room) {
		this.room = room;
	}

	public BookingRequest getBookingRequest() {
		return bookingRequest;
	}

	public void setBookingRequest(BookingRequest bookingRequest) {
		this.bookingRequest = bookingRequest;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("{");
		sb.append("primaryCommand='").append(primaryCommand).append('\'');
		sb.append(", secCommand='").append(secCommand).append('\'');
		sb.append(", building=").append(building);
		sb.append(", floor=").append(floor);
		sb.append(", room=").append(room);
		sb.append(", bookingRequest=").append(bookingRequest);
		sb.append('}');
		return sb.toString();
	}
}
