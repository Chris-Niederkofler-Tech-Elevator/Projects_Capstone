package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class MakeChange_Test {

	MakeChange change = new MakeChange();
	
	
	
	
	@Before
	public void setUp() throws Exception {
	change.giveChange(new BigDecimal("1.10"));
	
	}

	@Test
	public void test_Make_Change() {
		change.equals(4);
		change.equals(1);
		assertEquals(true, change.equals(change));
	}

}
       