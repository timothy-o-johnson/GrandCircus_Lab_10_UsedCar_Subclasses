/**
 * 
 * Tim Johnson
 * Grand Circus
 * 11/2/17
 * Lab9_Cars
 *
 */

import java.util.Scanner;

/*
 * holds details about the cars in Car Class
 */

public class Car{
	private String make;
	private String model;
	private int year;
	private double price;
	
	public Car() {
		this.make = "make";
		this.model = "model";
		this.year = 0;
		this.price = 0.0;
	}
	
	public Car(Scanner sc, int carNumber) { 
		this.make = Validator.getString(sc, "\nWhat's the make of car " + (carNumber +1) + "? ");
		this.model = Validator.getString(sc, "What's the model of car " + (carNumber +1) + "? ");
		this.year = Validator.getInt(sc, "When was car " + (carNumber +1) + " made? ", 1885, 2018);
		this.price = Validator.getDouble(sc, "How much does car " + (carNumber +1) + " cost? ", 0.0, 1000000.0);
	}
	
	public Car(String make, String model, int year, double price) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
	
		return String.format("%-20s %-20s %-20d $%-20.0f", make, model, year, price);
	}
	
	
	

}
