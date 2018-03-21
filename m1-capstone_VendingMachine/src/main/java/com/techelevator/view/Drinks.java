package com.techelevator.view;

import java.math.BigDecimal;

public class Drinks extends Inventory {
	
	public Drinks(String item, BigDecimal cost) {
		super(item,cost);
		
	}
	public String getSound() {
		return "Glug Glug, Yum!";
	

}
}
       