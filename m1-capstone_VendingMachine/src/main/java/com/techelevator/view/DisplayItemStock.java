package com.techelevator.view;


import java.io.File;
import java.io.FileNotFoundException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DisplayItemStock {
	
	public Map<String, List<Product>> importCsvFile() {
		File csvFile = new File("/Users/jgandhi/Development/team5-java-week4-pair-exercise/m1-capstone/vendingmachine.csv");
		
		Map<String, List<Product>> inventory = new TreeMap<>(); 
		
		try(Scanner stock = new Scanner(csvFile)) {
			while(stock.hasNextLine()) {
				String line = stock.nextLine();
				if(!line.isEmpty()) {
					String [] stockArray = line.split("\\|");
					
					if(stockArray[0].contains("A")) {
						List<Product> productArray = new ArrayList<>();
						for(int i = 0; i < 6; i++) {
							Chip var = new Chip(stockArray[1], new BigDecimal (stockArray[2]));
							productArray.add(var);
						}
						inventory.put(stockArray[0], productArray);
					} else if(stockArray[0].contains("C")) {
						List<Product> productArray = new ArrayList<>();
						for(int i = 0; i < 6; i++) {
							Drink var = new Drink(stockArray[1], new BigDecimal (stockArray[2]));
							productArray.add(var);
						}
						inventory.put(stockArray[0], productArray);
					} else if(stockArray[0].contains("B")) {
						List<Product> productArray = new ArrayList<>();
						for(int i = 0; i < 6; i++) {
							Candy var = new Candy(stockArray[1], new BigDecimal (stockArray[2]));
							productArray.add(var);
						}
						inventory.put(stockArray[0], productArray);
					} else {
						List<Product> productArray = new ArrayList<>();
						for(int i = 0; i < 6; i++) {
							Gum var = new Gum(stockArray[1], new BigDecimal (stockArray[2]));
							productArray.add(var);
						}
						inventory.put(stockArray[0], productArray);
					}
				}
			}
			return inventory; 
		} catch (FileNotFoundException e) {
			System.out.println("Invalid File");
			System.exit(1);
			return inventory;
		}
	}

}
