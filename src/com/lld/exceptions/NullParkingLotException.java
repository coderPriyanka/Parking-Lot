package com.lld.exceptions;

public class NullParkingLotException  extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NullParkingLotException(String message) {
		super(message);
	}

}