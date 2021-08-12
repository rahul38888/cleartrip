package com.cleartrip.commands;

import com.cleartrip.dao.DataHandler;
import com.cleartrip.exceptions.DataInsertionException;
import com.cleartrip.pojo.CommandObject;

public class ADD {
	public static void run(CommandObject commandObject) throws DataInsertionException {
		DataHandler dataHandler = DataHandler.getInstance();

		boolean response = false;
		if("BUILDING".equals(commandObject.getSecCommand()))
			response = dataHandler.addNewBuilding(commandObject.getBuilding());
		else if("FLOOR".equals(commandObject.getSecCommand()))
			response = dataHandler.addNewFloor(commandObject.getFloor());
		else if("CONFROOM".equals(commandObject.getSecCommand()))
			response = dataHandler.addNewConferenceRoom(commandObject.getRoom());

		if(!response)
			throw new DataInsertionException("Failed to add data: " + commandObject);
	}
}
