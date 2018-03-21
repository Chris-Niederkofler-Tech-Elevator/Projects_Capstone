package com.techelevator.view;

import java.math.BigDecimal;

public class makeChange {
	
	private double balanceX;
	private int quarters; 
	private int dime;
	private int nickels;

	public void Change (BigDecimal balance) {
		
		balanceX = (balance.doubleValue() * 100);
		quarters = ((int) balanceX / 25);
		balanceX = balanceX - (quarters * 25);
		dime = ((int) balanceX / 10);
		balanceX = balanceX - (dime * 10);
		nickels = ((int) balanceX / 5);
		balanceX = balanceX - (nickels * 5);
		
		System.out.println("Change is " + quarters + " quarters and " + dime + " dimes and " + nickels + " nickels");
	}
}
