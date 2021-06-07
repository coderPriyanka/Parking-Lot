package com.lld.model;

public class Slot {
	
	private int number;
	private Car parkedCar;
	
	public Slot(int number) {
		this.number = number;
	}
	
	public boolean isFree() {
		return parkedCar == null;
	}
	
	public void assignCar(Car car) {
		this.parkedCar = car;
	}
	
	public void deassignCar() {
		this.parkedCar = null;
	}
	
	public int getNumber() {
		return number;
	}
	public Car getParkedCar() {
		return parkedCar;
	}

}
