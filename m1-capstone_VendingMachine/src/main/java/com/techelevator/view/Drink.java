package com.techelevator.view;

import java.math.BigDecimal;

public class Drink extends Product {

	public Drink(String name, BigDecimal price) {
		super(name, price);
	}
	
	public String getSound() {
		return "Glug Glug, Yum!";
	}

}
