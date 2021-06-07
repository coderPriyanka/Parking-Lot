package com.lld.driver;

import static com.lld.util.Constants.PARK_COMMAND_NAME;

import com.lld.controller.ParkingLotController;
import com.lld.exceptions.SlotsNotAvailableException;
import com.lld.model.Car;
import com.lld.model.Command;
import com.lld.service.ParkingLotService;

public class ParkCarCommandDriver extends CommandDriver {
	
	public ParkCarCommandDriver(ParkingLotService parkingLotService) {
		super(parkingLotService);
	}

	@Override
	public boolean validate(Command command) {
		if (!command.getName().equals(PARK_COMMAND_NAME)) {
			return false;
		}
		return command.getParams().length == 2;
	}

	@Override
	public void execute(Command command) {
		String registrationNumber = command.getParams()[0];
		String color = command.getParams()[1];
		Car car = new Car(registrationNumber, color);
		try {
			int slot = parkingLotService.park(car);
			System.out.println("Allocated slot number: " + slot);
		} catch (SlotsNotAvailableException ex) {
			System.out.println("Sorry, parking lot is full");
		}
	}

}
