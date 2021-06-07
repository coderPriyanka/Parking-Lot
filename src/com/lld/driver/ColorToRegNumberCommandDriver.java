package com.lld.driver;

import static com.lld.util.Constants.REG_NUMBER_WITH_COLOR_COMMAND_NAME;

import java.util.List;

import com.lld.model.Command;
import com.lld.model.Slot;
import com.lld.service.ParkingLotService;

public class ColorToRegNumberCommandDriver extends CommandDriver {

	public ColorToRegNumberCommandDriver(ParkingLotService parkingLotService) {
		super(parkingLotService);
	}

	@Override
	public boolean validate(Command command) {
		if (!command.getName().equals(REG_NUMBER_WITH_COLOR_COMMAND_NAME)) {
			return false;
		}
		return command.getParams().length == 1;
	}

	@Override
	public void execute(Command command) {
		String color = command.getParams()[0];
		List<Slot> slotsForColor = parkingLotService.getSlotsForColor(color);
		if (slotsForColor.isEmpty()) {
			System.out.println("No cars are present with " + color + " color");
			return;
		}
		for (Slot slot : slotsForColor) {
			System.out.print(slot.getParkedCar().getRegistrationNumber() + " ");
		}
		System.out.println();
	}
}

