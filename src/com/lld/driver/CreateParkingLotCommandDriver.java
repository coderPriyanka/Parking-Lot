package com.lld.driver;

import com.lld.model.Command;
import com.lld.model.ParkingLot;
import com.lld.service.ParkingLotService;
import com.lld.strategy.NearestAvailableFromEntry;
import static com.lld.util.Constants.CREATE_COMMAND_NAME;
import com.lld.util.NumberValidator;

public class CreateParkingLotCommandDriver extends CommandDriver {
	
	public CreateParkingLotCommandDriver(ParkingLotService parkingLotService) {
		super(parkingLotService);
	}

	@Override
	public boolean validate(Command command) {
		if (!command.getName().equals(CREATE_COMMAND_NAME)) {
			return false;
		}
		if (command.getParams().length != 1) {
			return false;
		}
		return NumberValidator.isNumber(command.getParams()[0]);
	}

	@Override
	public void execute(Command command) {
		int capacity = Integer.parseInt(command.getParams()[0]);
		ParkingLot parkingLot = new ParkingLot(capacity, new NearestAvailableFromEntry());
		parkingLotService.createParkingLot(parkingLot);
		System.out.println("Created a parking lot with " + parkingLot.getCapacity() + " slots");
	}

}
