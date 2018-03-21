package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class Gum_Test {
  
	Gum vm;
	
	@Before
	public void setUp() throws Exception {
	vm = new Gum("FruitStripes", new BigDecimal(1.00));
	
	}
	 
	@Test
	public void test() {
	assertEquals("FruitStripes", vm.getItem());
	assertEquals("1.00", vm.getCost().toString());
	}   
	  
	@Test  
	public void sound_test() {
	assertEquals("Chew Chew, Yum!", vm.getSound());
	}
}

   
	

	