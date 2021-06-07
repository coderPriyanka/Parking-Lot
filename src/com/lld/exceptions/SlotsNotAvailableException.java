package com.lld.exceptions;

public class SlotsNotAvailableException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SlotsNotAvailableException(String message) {
		super(message);
	}

}