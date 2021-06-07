package com.lld.driver;

import static com.lld.util.Constants.SLOT_NUMBER_FOR_REG_NUMBER_COMMAND_NAME;

import java.util.List;

import com.lld.controller.ParkingLotController;
import com.lld.model.Command;
import com.lld.model.Slot;
import com.lld.service.ParkingLotService;

public class SlotForRegNumberCommandDriver extends CommandDriver {

	public SlotForRegNumberCommandDriver(ParkingLotService parkingLotService) {
		super(parkingLotService);
	}

	@Override
	public boolean validate(Command command) {
		if (!command.getName().equals(SLOT_NUMBER_FOR_REG_NUMBER_COMMAND_NAME)) {
			return false;
		}
		return command.getParams().length == 1;	
	}

	@Override
	public void execute(Command command) {
		String registrationNumber = command.getParams()[0];
		List<Slot> occupiedSlots = parkingLotService.getOccupiedSlots();
		if (occupiedSlots.isEmpty()) {
			System.out.println("All slots in the parking lot are empty");
			return;
		}
		for (Slot slot : occupiedSlots) {
			if (slot.getParkedCar().getRegistrationNumber().equals(registrationNumber)) {
				System.out.println(slot.getNumber());
				return;
			}
		}
		System.out.println("Not found");
	}

}
