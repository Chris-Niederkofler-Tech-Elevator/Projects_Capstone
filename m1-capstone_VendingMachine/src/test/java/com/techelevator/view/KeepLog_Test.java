package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class KeepLog_Test {

	KeepLog testLog = new KeepLog();
	Scanner in = new Scanner("./log.txt");
	
	
	@Before
	public void setUp() throws Exception {
	testLog.writer("Java is a bitch", new BigDecimal("1"), new BigDecimal("111"));
	
	}

	@Test
	public void test() {
	assertEquals(true, in.nextLine());
	in.nextLine();
	assertEquals(false, in.hasNextLine());
	}

}
     