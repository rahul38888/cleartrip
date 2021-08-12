package com.cleartrip.commands;

import com.cleartrip.dao.DataHandler;
import com.cleartrip.exceptions.BookingException;
import com.cleartrip.pojo.CommandObject;

public class CANCEL {

	public static void run(CommandObject commandObject) throws BookingException {
		DataHandler dataHandler = DataHandler.getInstance();

		boolean success = dataHandler.cancelBooking(commandObject.getBookingRequest());

		if(!success)
			throw new BookingException("Cannot cancel: " + commandObject.getBookingRequest());
	}
}
