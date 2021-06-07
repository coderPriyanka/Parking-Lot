package com.lld.controller;

import com.lld.model.Car;
import com.lld.model.ParkingLot;
import com.lld.service.ParkingLotService;

public class ParkingLotController {
	
	private ParkingLotService parkingLotService;
	
	public ParkingLotController(ParkingLotService parkingLotService) {
		this.parkingLotService = parkingLotService;
	}
	
	public ParkingLot getParkingLot() {
		return parkingLotService.getParkingLot();
	}
	
	public int park(Car car) {
		return parkingLotService.park(car);
	}
	
	public void unpark(int number) {
		parkingLotService.unpark(number);
	}

}
