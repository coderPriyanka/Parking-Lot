package com.lld.driver;

import static com.lld.util.Constants.STATUS_COMMAND_NAME;

import com.lld.controller.ParkingLotController;
import com.lld.model.Command;
import com.lld.service.ParkingLotService;

public class StatusCommandDriver extends CommandDriver {

	public StatusCommandDriver(ParkingLotService parkingLotService) {
		super(parkingLotService);
	}

	@Override
	public boolean validate(Command command) {
		if (!command.getName().equals(STATUS_COMMAND_NAME)) {
			return false;
		}
		return command.getParams().length == 0;
	}

	@Override
	public void execute(Command command) {
	}

}
