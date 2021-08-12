package com.cleartrip.pojo;

public class Floor {
	private String building;
	private Integer floor;

	public Floor(String building, Integer floor) {
		this.building = building;
		this.floor = floor;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Floor floor1 = (Floor) o;

		if (!building.equals(floor1.building)) return false;
		return floor.equals(floor1.floor);
	}

	@Override
	public int hashCode() {
		int result = building.hashCode();
		result = 31 * result + floor.hashCode();
		return result;
	}
}
