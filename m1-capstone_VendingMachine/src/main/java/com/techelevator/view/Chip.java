package com.techelevator.view;

import java.math.BigDecimal;

public class Chip extends Product {

	public Chip(String name, BigDecimal price) {
		super(name, price);
		
	}
	
	public String getSound() {
		return "Crunch Crunch, Yum!";
	}

}
