package com.techelevator.view;
	import java.util.ArrayList;
	import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
	import java.util.List;
	import java.math.BigDecimal; 

	public class Machine  {
		
		List<Inventory> buyingList = new ArrayList<>();
		Map<String, List<Inventory>> inventoryStock = new TreeMap<>();
		BigDecimal balance = new BigDecimal (0.00).setScale(2);
		KeepLog writer = new KeepLog(); 
		
		public Machine(Map<String, List<Inventory>> map) {
			this.inventoryStock = map;
		}
		
		public void displayItems() { 
			for(Entry<String, List<Inventory>> selection : inventoryStock.entrySet()) {
				String key = selection.getKey();
				List<Inventory> value = selection.getValue();
				if(value.size() == 1) {
					System.out.println(key + " is out of stock");
				} else {
					
				} System.out.println(key + " " + value.subList(0, 1) + " " + (value.size() -1));
			}
		}
		 
		public void feedMoney (int addMoney) {
			String transactionType = "Feed Money:";
			if(addMoney == 1) {
				balance = balance.add(new BigDecimal(1.00));
				writer.writer(transactionType, new BigDecimal(1.00).setScale(2), balance);
				
			} else if(addMoney == 2) {
				balance = balance.add(new BigDecimal(2.00));
				writer.writer(transactionType, new BigDecimal(2.00).setScale(2), balance);
				
			} else if(addMoney == 3) {
				balance = balance.add(new BigDecimal(5.00));
				writer.writer(transactionType, new BigDecimal(5.00).setScale(2), balance);
				
			} else if(addMoney == 4) {
				balance = balance.add(new BigDecimal(10.00));
				writer.writer(transactionType, new BigDecimal(10.00).setScale(2), balance);
			}
			System.out.println("Current balance is " + balance);
		}
		
		public void completeTransaction() {
			makeChange thisChange = new makeChange();
			thisChange.Change(balance);
			writer.writer("Give Change", balance, new BigDecimal(0.00).setScale(2));
			
			while(buyingList.size() > 0) {
				Inventory boughtItems = buyingList.remove(0);
				System.out.println(boughtItems.getSound());
			}
		}
		
		public void control (String inventoryControl) {
			if(! inventoryStock.containsKey(inventoryControl)) {
				System.out.println("Product is not valid");
			}
			if(inventoryStock.containsKey(inventoryControl)) {
				if(inventoryStock.get(inventoryControl).size() == 1) {
					System.out.println("Out of Stock");
				}
				if(inventoryStock.get(inventoryControl).size() >= 1) {
					if(balance.compareTo(inventoryStock.get(inventoryControl).get(0).getCost()) >= 0) {
						balance = balance.subtract(inventoryStock.get(inventoryControl).get(0).getCost());
						Inventory inventory = inventoryStock.get(inventoryControl).remove(0);
						buyingList.add(inventory);
						Inventory cost = inventoryStock.get(inventoryControl).get(1);
						BigDecimal costOf = cost.getCost();
						Inventory nameOf = inventoryStock.get(inventoryControl).get(0);
						String productOf = nameOf.getItem() + " " + inventoryControl;
						writer.writer(productOf, costOf, balance);
				} else {
					System.out.println("Please add money");
				}
			}
		}
			System.out.println("Your balance is " + balance);
}
	}   
 
