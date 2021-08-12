package com.cleartrip.pojo;

public class Building {
	private String building;

	public Building(String building) {
		this.building = building;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Building building1 = (Building) o;

		return building.equals(building1.building);
	}

	@Override
	public int hashCode() {
		return building.hashCode();
	}
}
