package com.techelevator.view;

import static org.junit.Assert.*;


import java.math.BigDecimal;

import org.junit.Before; 
import org.junit.BeforeClass;
import org.junit.Test;
public class Drinks_Test {
 
	Drinks vm;
	
	@Before
	public void setUp() throws Exception {
	vm = new Drinks("Pepsi", new BigDecimal("1.50"));
	}
	
  
	@Test
	public void test() {
	assertEquals("Pepsi", vm.getItem());
	assertEquals("1.50", vm.getCost().toString());
	}   
	@Test  
	public void sound_test() {
	assertEquals("Glug Glug, Yum!", vm.getSound());
	}
}

           