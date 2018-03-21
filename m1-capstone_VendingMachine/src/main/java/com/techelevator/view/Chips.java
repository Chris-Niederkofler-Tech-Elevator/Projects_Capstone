package com.techelevator.view;

import java.math.BigDecimal;

public class Chips extends Inventory {
	
	public Chips(String item, BigDecimal cost) {
		super(item,cost);
		
	}
	public String getSound() {
		return "Crunch Crunch, Yum!";
	}

}
   