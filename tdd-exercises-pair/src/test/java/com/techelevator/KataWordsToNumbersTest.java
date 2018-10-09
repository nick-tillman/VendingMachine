package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KataWordsToNumbersTest {
	
	private KataWordsToNumbers kat;
	
	@Before
	public void start() {
		kat = new KataWordsToNumbers();
	}
	
	@After
	public void end() {
		kat = null;
	}

	@Test
	public void StringLessThanOneHundredsTest() {

		Assert.assertEquals(7, kat.wordToNumber("seven"));
		Assert.assertEquals(0, kat.wordToNumber("zero"));
		Assert.assertEquals(10, kat.wordToNumber("ten"));
		Assert.assertEquals(15, kat.wordToNumber("fifteen"));
		Assert.assertEquals(20, kat.wordToNumber("twenty"));
		Assert.assertEquals(20, kat.wordToNumber("twenty"));
		Assert.assertEquals(50, kat.wordToNumber("fifty"));
		Assert.assertEquals(58, kat.wordToNumber("fifty-eight"));

	}

}
