package com.techelevator.view;

import java.math.BigDecimal;

public abstract class Inventory {  
	

	
		private String item;
		private BigDecimal cost;
		
		public Inventory(String item, BigDecimal cost) {
			this.item = item;
			this.cost = cost;
			
		}
		public abstract String getSound();
		
		@Override
		public String toString() {
			String result = item + " " + cost;
			return result;
		}

		public String getItem() {
			return item;
		}

		public void setItem(String item) {
			this.item = item;
		}

		public BigDecimal getCost() {
			return cost;
		}

		public void setCost(BigDecimal cost) {
			this.cost = cost;
		}
	
		
		
}

