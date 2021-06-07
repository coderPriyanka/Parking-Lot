package com.lld.driver;

import java.util.Scanner;

import com.lld.model.Command;
import com.lld.service.ParkingLotService;

public class Main {

	private static CommandDriver commandDriver;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ParkingLotService parkingLotService = new ParkingLotService();
		CommandDriverFactory.createCommandDrivers(parkingLotService);
		String input = in.nextLine();
		do {
			Command command = new Command(input);
			commandDriver = CommandDriverFactory.getCommandDriver(command);
			if (commandDriver.validate(command)) {
				commandDriver.execute(command);
			}
			input = in.nextLine();
		} while (!input.equals("exit"));
		in.close();
	}

}
