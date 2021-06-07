package com.lld.driver;

import static com.lld.util.Constants.UNPARK_COMMAND_NAME;

import com.lld.controller.ParkingLotController;
import com.lld.exceptions.InvalidInputException;
import com.lld.model.Command;
import com.lld.service.ParkingLotService;
import com.lld.util.NumberValidator;

public class UnparkCarCommandDriver extends CommandDriver {

	public UnparkCarCommandDriver(ParkingLotService parkingLotService) {
		super(parkingLotService);
	}

	@Override
	public boolean validate(Command command) {
		if (!command.getName().equals(UNPARK_COMMAND_NAME)) {
			return false;
		}
		if (command.getParams().length != 1) {
			return false;
		}
		return NumberValidator.isNumber(command.getParams()[0]);
	}

	@Override
	public void execute(Command command) {
		int slot = Integer.parseInt(command.getParams()[0]);
		try {
			parkingLotService.unpark(slot);
			System.out.println("Slot number " + slot + " is free");
		} catch (InvalidInputException ex) {
			System.out.println("The slot number is not a valid slot");
		}
	}

}
