package com.lld.util;

public class NumberValidator {
	
	public static boolean isNumber(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (!isDigit(input.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private static boolean isDigit(char ch) {
		return ch >= '0' && ch <= '9';
	}

}
