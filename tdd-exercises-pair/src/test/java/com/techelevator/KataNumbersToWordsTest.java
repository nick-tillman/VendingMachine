package com.techelevator;

import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class KataNumbersToWordsTest {
	
	private KataNumbersToWords kat;
	
	@Before
	public void start() {
		kat = new KataNumbersToWords();
	}
	
	@After
	public void end() {
		
		kat = null;
	}
	
	
	
	
	@Test
	public void KataTensTest() {
		Assert.assertEquals("zero", kat.numberToWord(0));
		Assert.assertEquals("one", kat.numberToWord(1));
		Assert.assertEquals("two", kat.numberToWord(2));
		Assert.assertEquals("three", kat.numberToWord(3));
		Assert.assertEquals("four", kat.numberToWord(4));
		Assert.assertEquals("five", kat.numberToWord(5));
		Assert.assertEquals("six", kat.numberToWord(6));
		Assert.assertEquals("seven", kat.numberToWord(7));
		Assert.assertEquals("eight", kat.numberToWord(8));
		Assert.assertEquals("nine", kat.numberToWord(9));
	}
	
	@Test
	public void KataLessThanOneHundredsTest() {
		Assert.assertEquals("fourteen", kat.numberToWord(14));
		Assert.assertEquals("thirty-nine", kat.numberToWord(39));
		Assert.assertEquals("fifty", kat.numberToWord(50));
		Assert.assertEquals("ninety-nine", kat.numberToWord(99));
		Assert.assertEquals("seventy-eight", kat.numberToWord(78));
		Assert.assertEquals("ninety-eight", kat.numberToWord(98));
	}
	
	@Test
	public void KataHundredsTest() {
		Assert.assertEquals(".numberToWord(100)", "one hundred", kat.numberToWord(100));
		Assert.assertEquals(".numberToWord(900)", "nine hundred", kat.numberToWord(900));
		Assert.assertEquals(".numberToWord(402)", "four hundred and two", kat.numberToWord(402));
		Assert.assertEquals(".numberToWord(811)", "eight hundred and eleven", kat.numberToWord(811));
		Assert.assertEquals(".numberToWord(453)", "four hundred and fifty-three", kat.numberToWord(453));

	}
	
	@Test
	public void KataThousandTest() {
		Assert.assertEquals(".numberToWord(1000))", "one thousand", kat.numberToWord(1000));
		Assert.assertEquals(".numberToWord(1001))", "one thousand and one", kat.numberToWord(1001));
		
	}
}
