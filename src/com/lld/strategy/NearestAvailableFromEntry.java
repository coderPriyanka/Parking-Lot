package com.lld.strategy;

import java.util.TreeSet;

import com.lld.exceptions.SlotsNotAvailableException;

public class NearestAvailableFromEntry implements ParkingStrategy {
	
	private TreeSet<Integer> slots;
	
	public NearestAvailableFromEntry() {
		this.slots = new TreeSet<>();
	}

	@Override
	public void addSlot(int slotNumber) {
		slots.add(slotNumber);
	}

	@Override
	public void removeSlot(int slotNumber) {
		slots.remove(slotNumber);
	}

	@Override
	public int nextAvailableSlot() {
		if (slots.isEmpty()) {
			throw new SlotsNotAvailableException("No free slots are available");
		}
		return slots.first();
	}

}
