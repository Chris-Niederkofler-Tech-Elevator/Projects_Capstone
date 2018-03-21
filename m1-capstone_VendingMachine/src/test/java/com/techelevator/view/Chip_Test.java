package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;


public class Chip_Test {

	Chips vm;
	
	@Before
	public void setUp() throws Exception {
		vm = new Chips("Lays", new BigDecimal("1.25")); 
	}
	
	
	@Test
	public void test() {
	assertEquals("Lays", vm.getItem());
	assertEquals("1.25", vm.getCost().toString());
	}  
	@Test 
	public void sound_test() {
	assertEquals("Crunch Crunch, Yum!", vm.getSound());
	}
	} 

  
     