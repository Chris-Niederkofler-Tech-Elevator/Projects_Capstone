package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class MakeChangeTest {
	
	makeChange change = new makeChange();

	@Before
	public void setUp() throws Exception {
		change.Change(new BigDecimal ("1.10"));
	}

	}


