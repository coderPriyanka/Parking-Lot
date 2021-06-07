package com.lld.model;

import static com.lld.util.ParkingLotUtil.MAX_CAPACITY;

import java.util.HashMap;
import java.util.Map;

import com.lld.exceptions.InvalidInputException;
import com.lld.strategy.ParkingStrategy;
import com.lld.util.ParkingLotUtil;;

public class ParkingLot {
	
	private int capacity;
	private Map<Integer, Slot> slots;
	private ParkingStrategy parkingStrategy;
	
	public ParkingLot(int capacity, ParkingStrategy parkingStrategy) {
		if (capacity <= 0 || capacity > MAX_CAPACITY) {
			throw new InvalidInputException("Capacity is beyond the valid range");
		}
		this.capacity = capacity;
		this.slots = new HashMap<>();
		this.parkingStrategy = parkingStrategy;
		for (int i = 1; i <= capacity; i++) {
			this.parkingStrategy.addSlot(i);
		}
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public Map<Integer, Slot> allSlots() {
		return slots;
	}
	
	public Slot addSlot(int number) {
		ParkingLotUtil.validateSlot(number);
		if (!slots.containsKey(number)) {
			slots.put(number, new Slot(number));
		}
		return slots.get(number);
	}
	
	public Slot park(Car car) {
		int slotNumber = parkingStrategy.nextAvailableSlot();
		ParkingLotUtil.validateSlot(slotNumber);
		parkingStrategy.removeSlot(slotNumber);
		if (!slots.containsKey(slotNumber)) {
			addSlot(slotNumber);
		}
		slots.get(slotNumber).assignCar(car);
		return slots.get(slotNumber);
	}
	
	public void unpark(int number) {
		if (number <= 0 || number > MAX_CAPACITY || !slots.containsKey(number)) {
			throw new InvalidInputException("Not a valid slot number");
		}
		parkingStrategy.addSlot(number);
		slots.get(number).deassignCar();
	}
}
