package com.techelevator.view;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap; 

import org.junit.Before;
import org.junit.Test;

public class Machine_Test {

	Machine vm;
	Chips chips = new Chips("Cheetos", new BigDecimal("1.50"));
	List<Inventory> newProductArray = new ArrayList<>();
	Map<String, List<Inventory>> inventory = new TreeMap<String, List<Inventory>>();
	
	
	@Before
	public void setUp() throws Exception {
	vm = new Machine(inventory);
	newProductArray.add(chips);
	inventory.put("A1", newProductArray);
	}

	@Test
	public void test_feed_money() {
		vm.feedMoney(3);
		assertEquals(new BigDecimal("5.00"), vm.balance);
		vm.completeTransaction();
		vm.feedMoney(2);
		assertEquals(new BigDecimal("7.00"), vm.balance);
		vm.completeTransaction();
	}
	@Test
	public void test_buying_and_updating_balance() {
		vm.feedMoney(4);
		vm.control("A1");
		assertEquals(new BigDecimal ("9.00"), vm.balance);
		vm.completeTransaction();
		
	} 
	@Test
	public void test_ending_with_zero_balance() { 
		vm.feedMoney(1);
		vm.control("A1");
		assertEquals(new BigDecimal("0.00"), vm.balance);
		vm.completeTransaction();
	}
	@Test
	public void test_if_there_is_no_money_for_purchase() {
		vm.control("A1");
		assertEquals(1, inventory.size());
		vm.completeTransaction();
	}
	@Test
	public void test_Display_Items() {
		vm.displayItems(); 
	} 
 
}   
   