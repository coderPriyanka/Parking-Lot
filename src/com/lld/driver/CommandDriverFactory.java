package com.lld.driver;

import java.util.HashMap;
import java.util.Map;

import com.lld.exceptions.InvalidInputException;
import com.lld.model.Command;
import com.lld.service.ParkingLotService;

import static com.lld.util.Constants.*;

public class CommandDriverFactory {
	
	private static Map<String, CommandDriver> commandToDriver;
	
	public static void createCommandDrivers(ParkingLotService parkingLotService) {
		commandToDriver = new HashMap<>();
		commandToDriver.put(CREATE_COMMAND_NAME, new CreateParkingLotCommandDriver(parkingLotService));
		commandToDriver.put(PARK_COMMAND_NAME, new ParkCarCommandDriver(parkingLotService));
		commandToDriver.put(UNPARK_COMMAND_NAME, new UnparkCarCommandDriver(parkingLotService));
		commandToDriver.put(STATUS_COMMAND_NAME, new StatusCommandDriver(parkingLotService));
		commandToDriver.put(REG_NUMBER_WITH_COLOR_COMMAND_NAME, new ColorToRegNumberCommandDriver(parkingLotService));
		commandToDriver.put(SLOT_NUMBER_FOR_COLOR_COMMAND_NAME, new SlotForColorCommandDriver(parkingLotService));
		commandToDriver.put(SLOT_NUMBER_FOR_REG_NUMBER_COMMAND_NAME, new SlotForRegNumberCommandDriver(parkingLotService));
	}
		
	public static CommandDriver getCommandDriver(final Command command) {
		if (!commandToDriver.containsKey(command.getName())) {
			throw new InvalidInputException("");
		}
		return commandToDriver.get(command.getName());
	}

}
