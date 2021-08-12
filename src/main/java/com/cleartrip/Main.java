package com.cleartrip;

import com.cleartrip.commands.ADD;
import com.cleartrip.commands.BOOK;
import com.cleartrip.commands.CANCEL;
import com.cleartrip.exceptions.BookingException;
import com.cleartrip.exceptions.DataInsertionException;
import com.cleartrip.pojo.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		if(args.length < 1 || StringUtils.isEmpty(args[0]))
			throw new InvalidParameterException("File name required as argument");
		List<String> strings = FileUtils.readLines(new File(args[0]));

		for(String s: strings){
			String[] values = s.split(" ");
			CommandObject commandObject = parseRequest(values);
			try{
				if("ADD".equals(commandObject.getPrimaryCommand()))
					ADD.run(commandObject);
				else if("BOOK".equals(commandObject.getPrimaryCommand()))
					BOOK.run(commandObject);
				else if("CANCEL".equals(commandObject.getPrimaryCommand()))
					CANCEL.run(commandObject);

			} catch (DataInsertionException | BookingException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static CommandObject parseRequest(String[] values){
		String primaryCommand = values[0];
		CommandObject commandObject = new CommandObject();
		commandObject.setPrimaryCommand(primaryCommand);
		if("ADD".equals(primaryCommand)){
			String secCommand = values[1];
			commandObject.setSecCommand(secCommand);
			if("BUILDING".equals(values[1])){
				commandObject.setBuilding(new Building(values[2]));
			}
			else if("FLOOR".equals(values[1])){
				commandObject.setFloor(new Floor(values[2], Integer.parseInt(values[3])));
			}
			else if("CONFROOM".equals(values[1])){
				commandObject.setRoom(new ConferenceRoom(values[2], Integer.parseInt(values[3]),
						values[4], Integer.parseInt(values[5])));
			}
		}
		else if("BOOK".equals(values[0]) || "CANCEL".equals(values[0])){
			String slotsString = values[1];
			String[] tupple = slotsString.split(":");
			Set<Integer> slots = new HashSet<>();
			for (int i = Integer.parseInt(tupple[0]); i <= Integer.parseInt(tupple[1]); i++)
				slots.add(i);

			ConferenceRoom room = new ConferenceRoom(values[2], Integer.parseInt(values[3]),
					values[4]);

			String userId = values[5];
			commandObject.setBookingRequest(new BookingRequest(userId, slots, room));
		}
		else if("LIST".equals(values[0])){

		}
		else if("SEARCH".equals(values[0])){

		}

		return commandObject;
	}

}
