package com.cleartrip.commands;

import com.cleartrip.dao.DataHandler;
import com.cleartrip.exceptions.BookingException;
import com.cleartrip.pojo.CommandObject;

public class BOOK {

	public static void run(CommandObject commandObject) throws BookingException {
		DataHandler dataHandler = DataHandler.getInstance();

		boolean success = dataHandler.bookConferenceRoom(commandObject.getBookingRequest());

		if(!success)
			throw new BookingException("Not available for provided request: " + commandObject.getBookingRequest());
	}
}
