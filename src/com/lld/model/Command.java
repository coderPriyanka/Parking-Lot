package com.lld.model;

import com.lld.exceptions.InvalidInputException;

public class Command {
	
	private String name;
	private String[] params;
	
	public Command(String input) {
		if (input == null || input == "" ) {
			throw new InvalidInputException("The input command is empty or null");
		}
		String[] commandParams = input.split(" ");
		if (commandParams.length <= 1) {
			throw new InvalidInputException("No command parameters provided");
		}
		this.name = commandParams[0].toLowerCase();
		params = new String[commandParams.length - 1];
		for (int i = 1; i < commandParams.length; i++) {
			params[i - 1] = commandParams[i];
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String[] getParams() {
		return params;
	}
	
}
