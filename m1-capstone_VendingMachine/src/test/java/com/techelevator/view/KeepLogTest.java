package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class KeepLogTest {
	
	KeepLog testLog = new KeepLog();
	Scanner in = new Scanner("./log.txt");

	@Before
	public void setUp() throws Exception {
		testLog.writer("Java Is Cool!", new BigDecimal("1.00"), new BigDecimal("1.11"));
	}

	@Test
	public void test() {
		assertEquals(true, in.hasNextLine());
		in.nextLine();
		assertEquals(false, in.hasNextLine());
	}

}
