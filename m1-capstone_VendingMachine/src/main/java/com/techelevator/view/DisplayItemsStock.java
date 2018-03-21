package com.techelevator.view;

import java.io.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DisplayItemsStock {

	public Map<String, List<Inventory>> importedCsv() {
		File inventoryFile = new File(
				"/Users/cniederkofler/Development/workspace/pair_exercises/team5-java-week4-pair-exercise/m1-capstone/vendingmachine.csv");

		Map<String, List<Inventory>> vendingMachineItems = new TreeMap<>();

		try (Scanner importStock = new Scanner(inventoryFile)) {
			while (importStock.hasNextLine()) {
				String line = importStock.nextLine();
				if (!line.isEmpty()) {
					String[] importStockArray = line.split("\\|");

					if (importStockArray[0].contains("A")) {
						List<Inventory> inventoryArray = new ArrayList<>();
						for (int i = 0; i < 6; i++) {
							Chips bag = new Chips(importStockArray[1], new BigDecimal(importStockArray[2]));
							new BigDecimal(importStockArray[2]);
							inventoryArray.add(bag);
						}
						vendingMachineItems.put(importStockArray[0], inventoryArray);

					} else if (importStockArray[0].contains("C")) {
						List<Inventory> inventoryArray = new ArrayList<>();
						for (int i = 0; i < 6; i++) {
							Drinks bag = new Drinks(importStockArray[1], new BigDecimal(importStockArray[2]));
							new BigDecimal(importStockArray[2]);
							inventoryArray.add(bag);
						}
						vendingMachineItems.put(importStockArray[0], inventoryArray);

					} else if (importStockArray[0].contains("B")) {
						List<Inventory> inventoryArray = new ArrayList<>();
						for (int i = 0; i < 6; i++) {
							Candy bag = new Candy(importStockArray[1], new BigDecimal(importStockArray[2]));
							new BigDecimal(importStockArray[2]);
							inventoryArray.add(bag);
						}
						vendingMachineItems.put(importStockArray[0], inventoryArray);

					} else {
						List<Inventory> inventoryArray = new ArrayList<>();
						for (int i = 0; i < 6; i++) {
							Gum bag = new Gum(importStockArray[1], new BigDecimal(importStockArray[2]));
							new BigDecimal(importStockArray[2]);
							inventoryArray.add(bag);
						}
						vendingMachineItems.put(importStockArray[0], inventoryArray);

					}
				}
			}
			return vendingMachineItems;

		} catch (FileNotFoundException e) {
			System.out.println("Invalid File");
			System.exit(1);
			return vendingMachineItems;
		}
	}
}
