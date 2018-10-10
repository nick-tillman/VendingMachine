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
	public void stringLessThanOneHundredsTest() {

		Assert.assertEquals(7, kat.wordToNumber("seven"));
		Assert.assertEquals(0, kat.wordToNumber("zero"));
		Assert.assertEquals(10, kat.wordToNumber("ten"));
		Assert.assertEquals(15, kat.wordToNumber("fifteen"));
		Assert.assertEquals(20, kat.wordToNumber("twenty"));
		Assert.assertEquals(20, kat.wordToNumber("twenty"));
		Assert.assertEquals(50, kat.wordToNumber("fifty"));
		Assert.assertEquals(99, kat.wordToNumber("ninety-nine"));
		Assert.assertEquals(75, kat.wordToNumber("seventy-five"));
		Assert.assertEquals(32, kat.wordToNumber("thirty-two"));
	}
	
	@Test
	public void stringLessThanOneThousandTest() {
		Assert.assertEquals(100, kat.wordToNumber("one hundred"));
		Assert.assertEquals(101, kat.wordToNumber("one hundred and one"));
		Assert.assertEquals(222, kat.wordToNumber("two hundred and twenty-two"));
		Assert.assertEquals(573, kat.wordToNumber("five hundred and seventy-three"));
		Assert.assertEquals(730, kat.wordToNumber("seven hundred and thirty"));
		Assert.assertEquals(999, kat.wordToNumber("nine hundred and ninety-nine"));

	}
	
	@Test
	public void stringOverOneThousandTest() {
		Assert.assertEquals(1000, kat.wordToNumber("one thousand"));
		Assert.assertEquals(1001, kat.wordToNumber("one thousand and one"));
		Assert.assertEquals(2020, kat.wordToNumber("two thousand and twenty"));
		Assert.assertEquals(5346, kat.wordToNumber("five thousand three hundred and forty-six"));
		Assert.assertEquals(10267, kat.wordToNumber("ten thousand two hundred and sixty-seven"));
		Assert.assertEquals(50004, kat.wordToNumber("fifty thousand and four"));
		Assert.assertEquals(60072, kat.wordToNumber("sixty thousand and seventy-two"));
		//Assert.assertEquals(33456, kat.wordToNumber("thirty-three thousand four hundred and fifty-six"));




	}

}
