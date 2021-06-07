package com.lld.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lld.exceptions.NullParkingLotException;
import com.lld.model.Car;
import com.lld.model.ParkingLot;
import com.lld.model.Slot;;

public class ParkingLotService {
	
	private ParkingLot parkingLot;
	
	public void createParkingLot(ParkingLot parkingLot) {
		if (parkingLot == null) {
			throw new NullParkingLotException("Parking lot can not be empty");
		}
		this.parkingLot = parkingLot;
	}
	
	public ParkingLot getParkingLot() {
		return parkingLot;
	}
	
	public int getCapacity() {
		return parkingLot.getCapacity();
	}
	
	public Map<Integer, Slot> allSlots() {
		return parkingLot.allSlots();
	}
	
	public Slot addSlot(int number) {
		return parkingLot.addSlot(number);
	}
	
	public int park(Car car) {
		return parkingLot.park(car).getNumber();
	}
	
	public void unpark(int number) {
		parkingLot.unpark(number);
	}
	
	public List<Slot> getOccupiedSlots() {
		Map<Integer, Slot> allSlots = parkingLot.allSlots();
		List<Slot> occupiedSlots = new ArrayList<>();
		for (int i = 1; i <= parkingLot.getCapacity(); i++) {
			if (allSlots.containsKey(i) && !allSlots.get(i).isFree()) {
				occupiedSlots.add(allSlots.get(i));
			}
		}
		return occupiedSlots;
	}
	
	public List<Slot> getSlotsForColor(String color) {
		List<Slot> allOccupiedSlots = getOccupiedSlots();
		List<Slot> slotsForColor = new ArrayList<>();
		for (Slot slot : allOccupiedSlots) {
			if (slot.getParkedCar().getColor().equals(color)) {
				slotsForColor.add(slot);
			}
		}
		return slotsForColor;
	}
}
