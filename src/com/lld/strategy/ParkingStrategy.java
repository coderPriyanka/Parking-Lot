package com.lld.strategy;

public interface ParkingStrategy {
	
	void addSlot(int slotNumber);
	
	void removeSlot(int slotNumber);
	
	int nextAvailableSlot();
	
}
