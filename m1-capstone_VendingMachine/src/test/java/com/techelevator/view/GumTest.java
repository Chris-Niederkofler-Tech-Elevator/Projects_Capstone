package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class GumTest {

	Gum vm;

	@Before
	public void setUp() throws Exception {
		vm = new Gum("Five", new BigDecimal ("1.00"));
	}

	@Test
	public void test_Gum() {
		assertEquals("Five", vm.getName());
		assertEquals("1.00", vm.getPrice().toString());
	}
	
	@Test
	public void test_Sound() {
		assertEquals("Chew Chew, Yum!", vm.getSound());
	}

}
