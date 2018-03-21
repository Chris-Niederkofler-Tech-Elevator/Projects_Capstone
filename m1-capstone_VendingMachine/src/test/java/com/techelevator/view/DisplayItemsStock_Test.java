package com.techelevator.view;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List; 
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class DisplayItemsStock_Test {

	
	DisplayItemsStock vm;

	@Test
	public void imported_CSV_Test() {
	vm = new DisplayItemsStock();
	Map<String, List<Inventory>> testMap = vm.importedCsv();
	
	Inventory x = testMap.get("A4").get(0);
	assertEquals("Cloud Popcorn", x.getItem());
	
	assertEquals(new BigDecimal("3.65"), x.getCost());
	
	assertEquals(true, testMap.containsKey("A4"));
	

}

}    
     