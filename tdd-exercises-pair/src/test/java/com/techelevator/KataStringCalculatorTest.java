package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;


public class KataStringCalculatorTest {
	
	private KataStringCalculator kat;
	
	@Before
	public void start() {
		kat = new KataStringCalculator();
	}
	
	@After
	public void end() {
		kat = null;
	}
	
	@Test
	public void KataStringCalc_Test0() {
		Assert.assertEquals(".add(\"0\")", 0, kat.add("0"));
	}
	
	@Test
	public void KataStringCalc_Test1and2() {
		Assert.assertEquals(".add(\"1\")",1, kat.add("1"));
		Assert.assertEquals(".add(\"1,2\")", 3, kat.add("1,2"));
		Assert.assertEquals(".add(\"-1,3\")", 2, kat.add("-1,3"));
		Assert.assertEquals(".add(\"-3,-1\")", -4, kat.add("-3,-1"));
	}
	
	@Test
	public void KataStringNewLineTest() {
		Assert.assertEquals(".add(\"1\\n2,3,4,5\")", 15, kat.add("1\n2,3,4,5"));
		Assert.assertEquals(".add(\"-1\\n-2\\n3,\\n4,5\")", 9, kat.add("-1\n-2\n3\n4,5"));
		Assert.assertFalse(".add(\"-3,-1\") == 5", kat.add("1\n2,3,4,5") == 10);
		Assert.assertFalse(".add(\"-3,-1\") == 5", kat.add("0,0,0") == 2);
		Assert.assertFalse(".add(\"-3,-1\") == 5", kat.add("-1,-2,-3") == 6);
	}
	
	@Test
	public void KataStringDelimiterTest() {
		Assert.assertEquals("", 15, kat.add("//:\n1:2:3:4:5"));
		Assert.assertEquals("", 0, kat.add("//:\n-2:-10:3:4:5"));
		Assert.assertEquals("", 0, kat.add("//:\n0:1:2:-1:-2"));
	}
	
}
