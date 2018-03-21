package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

public class MachineTest {
	
	Machine vm; 
	Chip chip = new Chip("Cheetos", new BigDecimal("1.00"));
	List<Product> newProductArray = new ArrayList<>();
	Map<String, List<Product>> inventory = new TreeMap<String, List<Product>>();

	@Before
	public void setUp() throws Exception {
		vm = new Machine(inventory);
		newProductArray.add(chip);
		newProductArray.add(chip);
		newProductArray.add(chip);
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
	public void test_buying_something_and_updating_the_balance() {
		vm.feedMoney(4);
		vm.control("A1");
		assertEquals(new BigDecimal ("9.00"), vm.balance);
		vm.completeTransaction();
	}
	
	@Test 
	public void test_ending_transaction_with_zero_balance() {
		vm.feedMoney(1);
		vm.control("A1");
		vm.completeTransaction();
		assertEquals(new BigDecimal("0.00"), vm.balance);
	} 
	@Test
	public void test_if_there_is_no_money_for_buying_things() {
		vm.control("A1");
		assertEquals(1, inventory.size());
		vm.completeTransaction();
	}
	
	@Test
	public void test_displaying_items() {
		vm.displayItems();
		assertEquals(1, inventory.size());
	}

}
 