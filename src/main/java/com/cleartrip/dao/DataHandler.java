package com.cleartrip.dao;

import com.cleartrip.pojo.BookingRequest;
import com.cleartrip.pojo.Building;
import com.cleartrip.pojo.ConferenceRoom;
import com.cleartrip.pojo.Floor;

import java.util.*;

public class DataHandler {

	static private DataHandler dataHandler;

	private Set<Building> buildings = new HashSet<>();
	private Set<Floor> floors = new HashSet<>();
	private Set<ConferenceRoom> rooms = new HashSet<>();

	private HashMap<Integer, Set<ConferenceRoom>> timeSlotMap = new HashMap<>();
	private HashMap<String, Set<ConferenceRoom>> buildingMap = new HashMap<>();
	private HashMap<Integer, Set<ConferenceRoom>> floorMap = new HashMap<>();

	private DataHandler(){

	}

	public static DataHandler getInstance(){
		if(dataHandler==null)
			dataHandler = new DataHandler();

		return dataHandler;
	}

	public boolean addNewBuilding(Building building){
		buildings.add(building);
		return true;
	}

	public boolean addNewFloor(Floor floor){
		if(!buildings.contains(new Building(floor.getBuilding())))
			return false;

		floors.add(floor);
		return true;
	}

	public boolean addNewConferenceRoom(ConferenceRoom room){
		if(!buildings.contains(new Building(room.getBuilding())) ||
				!floors.contains(new Floor(room.getBuilding(), room.getFloor())))
			return false;

		rooms.add(room);

		if(!buildingMap.containsKey(room.getBuilding()))
			buildingMap.put(room.getBuilding(), new HashSet<>());
		buildingMap.get(room.getBuilding()).add(room);

		if(!floorMap.containsKey(room.getFloor()))
			floorMap.put(room.getFloor(), new HashSet<>());
		floorMap.get(room.getFloor()).add(room);

		for (int i = 1; i <= 24; i++) {
			if(!timeSlotMap.containsKey(i))
				timeSlotMap.put(i, new HashSet<>());
			timeSlotMap.get(i).add(room);
		}

		return true;
	}

	public boolean cancelBooking(BookingRequest bookingRequest) {
		ConferenceRoom room = bookingRequest.getRoom();

		for(ConferenceRoom room1: rooms){
			if (room1.equals(room)) {
				room = room1;
				break;
			}
		}

		if(!buildings.contains(new Building(room.getBuilding())) ||
				!floors.contains(new Floor(room.getBuilding(), room.getFloor())))
			return false;

		for(Integer slot: bookingRequest.getSlots())
			timeSlotMap.get(slot).add(room);

		buildingMap.get(room.getBuilding()).add(room);
		floorMap.get(room.getFloor()).add(room);

		return true;
	}

	public boolean bookConferenceRoom(BookingRequest bookingRequest){
		ConferenceRoom room = bookingRequest.getRoom();

		if(!buildings.contains(new Building(room.getBuilding())) ||
				!floors.contains(new Floor(room.getBuilding(), room.getFloor())))
			return false;

		boolean avaialable = true;
		for(Integer slot: bookingRequest.getSlots())
			if(!timeSlotMap.get(slot).contains(room)) {
				avaialable = false;
				break;
			}

		if(!avaialable)
			return false;

		for(Integer slot: bookingRequest.getSlots())
			timeSlotMap.get(slot).remove(room);

		buildingMap.get(room.getBuilding()).remove(room);
		floorMap.get(room.getFloor()).remove(room);

		return true;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("DataHandler{");
		sb.append("buildings=").append(buildings);
		sb.append(", floors=").append(floors);
		sb.append(", rooms=").append(rooms);
		sb.append(", timeSlotMap=").append(timeSlotMap);
		sb.append(", buildingMap=").append(buildingMap);
		sb.append(", floorMap=").append(floorMap);
		sb.append('}');
		return sb.toString();
	}
}
