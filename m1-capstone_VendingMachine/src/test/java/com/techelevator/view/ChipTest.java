package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ChipTest {

	Chip vm;

	@Before
	public void setUp() throws Exception {
		vm = new Chip("Lays", new BigDecimal ("1.25"));
	}

	@Test
	public void test_Chip() {
		assertEquals("Lays", vm.getName());
		assertEquals("1.25", vm.getPrice().toString());
	}
	
	@Test
	public void test_Sound() {
		assertEquals("Crunch Crunch, Yum!", vm.getSound());
	}

}
