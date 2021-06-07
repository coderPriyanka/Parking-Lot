package com.lld.driver;

import static com.lld.util.Constants.SLOT_NUMBER_FOR_COLOR_COMMAND_NAME;

import java.util.List;

import com.lld.controller.ParkingLotController;
import com.lld.model.Command;
import com.lld.model.Slot;
import com.lld.service.ParkingLotService;

public class SlotForColorCommandDriver extends CommandDriver {

	public SlotForColorCommandDriver(ParkingLotService parkingLotService) {
		super(parkingLotService);
	}

	@Override
	public boolean validate(Command command) {
		if (!command.getName().equals(SLOT_NUMBER_FOR_COLOR_COMMAND_NAME)) {
			return false;
		}
		return command.getParams().length == 1;
	}

	@Override
	public void execute(Command command) {
		String color = command.getParams()[0];
		List<Slot> slotsForColor = parkingLotService.getSlotsForColor(color);
		if (slotsForColor.isEmpty()) {
			System.out.println("No slots are occupied by car with " + color + " color");
			return;
		}
		System.out.println("The occupied slots for car with " + color + " color are : ");
		for (Slot slot : slotsForColor) {
			if (slot.getParkedCar().getColor().equals(color)) {
				System.out.print(slot.getNumber() + " ");
			}
		}
		System.out.println();
	}
}
