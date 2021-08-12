package com.cleartrip.pojo;

import java.util.Set;

public class BookingRequest {
	private String userId;
	private Set<Integer> slots;
	private ConferenceRoom room;

	public BookingRequest(String userId, Set<Integer> slots, ConferenceRoom room) {
		this.userId = userId;
		this.slots = slots;
		this.room = room;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Set<Integer> getSlots() {
		return slots;
	}

	public void setSlots(Set<Integer> slots) {
		this.slots = slots;
	}

	public ConferenceRoom getRoom() {
		return room;
	}

	public void setRoom(ConferenceRoom room) {
		this.room = room;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("BookingRequest{");
		sb.append("userId='").append(userId).append('\'');
		sb.append(", slots=").append(slots);
		sb.append(", room=").append(room);
		sb.append('}');
		return sb.toString();
	}
}
