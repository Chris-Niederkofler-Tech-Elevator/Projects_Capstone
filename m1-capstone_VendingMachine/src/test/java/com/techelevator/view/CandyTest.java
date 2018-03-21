package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class CandyTest {
	
	Candy vm;

	@Before
	public void setUp() throws Exception {
		vm = new Candy("Three Musketeers", new BigDecimal ("1.00"));
	}

	@Test
	public void test_Candy() {
		assertEquals("Three Musketeers", vm.getName());
		assertEquals("1.00", vm.getPrice().toString());
	}
	
	@Test
	public void test_Sound() {
		assertEquals("Munch Munch, Yum!", vm.getSound());
	}

}
