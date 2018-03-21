package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class DrinkTest {

	Drink vm;

	@Before
	public void setUp() throws Exception {
		vm = new Drink("Pepsi", new BigDecimal ("1.50"));
	}

	@Test
	public void test_Drink() {
		assertEquals("Pepsi", vm.getName());
		assertEquals("1.50", vm.getPrice().toString());
	}
	
	@Test
	public void test_Sound() {
		assertEquals("Glug Glug, Yum!", vm.getSound());
	}

}
