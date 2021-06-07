package com.lld.driver;

import com.lld.model.Command;
import com.lld.service.ParkingLotService;

public abstract class CommandDriver {
	
	protected ParkingLotService parkingLotService;
	
	public CommandDriver(ParkingLotService parkingLotService) {
		this.parkingLotService = parkingLotService;
	}

	public abstract boolean validate(Command command);
	
	public abstract void execute(Command command);
	
}
