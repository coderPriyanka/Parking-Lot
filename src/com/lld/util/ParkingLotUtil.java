package com.lld.util;

import com.lld.exceptions.InvalidInputException;

public class ParkingLotUtil {
	
	public static final int MAX_CAPACITY = 10000;
	
	public static void validateSlot(int number) {
		if (number <= 0 || number > MAX_CAPACITY) {
			throw new InvalidInputException("Not a valid slot number");
		}
	}
	
	public static void validateCapacity(int capacity) {
		if (capacity <= 0 || capacity > MAX_CAPACITY) {
			throw new InvalidInputException("Capacity is not within the valid range");
		}
	}

}
