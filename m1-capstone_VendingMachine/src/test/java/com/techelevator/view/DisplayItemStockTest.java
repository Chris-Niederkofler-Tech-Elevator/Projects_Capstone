package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class DisplayItemStockTest {
	
	DisplayItemStock vm; 


	@Test
	public void test_Csv_file() {
		vm = new DisplayItemStock();
		Map<String, List<Product>> testNewMap = vm.importCsvFile();
		
		Product x = testNewMap.get("A4").get(0);
		assertEquals("Cloud Popcorn", x.getName());
		assertEquals(new BigDecimal("3.65"), x.getPrice());
		assertEquals(true, testNewMap.containsKey("A4"));
	}

}
