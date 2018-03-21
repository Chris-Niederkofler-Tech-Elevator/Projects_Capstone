package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Candy_Test {

	Candy vm;
	
	@Before
	public void setUp() {
		vm = new Candy("Candy Bars", new BigDecimal("1.00"));
	}
	
	
	@Test
	public void test() {
	assertEquals("Candy Bars", vm.getItem());
	assertEquals("1.00", vm.getCost().toString());
	}  
	@Test 
	public void sound_test() {
		assertEquals("Munch Munch, Yum!", vm.getSound());
	}

} 
