package com.techelevator;

import java.util.HashMap;

public class KataNumbersToWords {
	
	private static HashMap<Integer, String> onesMap = new HashMap<Integer, String>();
	private static HashMap<Integer, String> teensMap = new HashMap<Integer, String>();
	private static HashMap<Integer, String> doubleDigit = new HashMap<Integer, String>();
	private KataNumbersToWords kat;

	
	public String numberToWord(int num) {
		kat = new KataNumbersToWords();
		kat.buildHashMaps();
		String numString = "";
		
		//These 4 lines of code convert our passed in 'num' to a temporary char array, and then to an int array we
		//we will use as keys for our hashmap.
		String temp = Integer.toString(num);
		char[] chars = temp.toCharArray();
		int[] values = new int[temp.length()];
		for(int i = 0; i < temp.length(); i++) {
			values[i] = Character.getNumericValue(chars[i]);
		}
		
		//Here we check the length of our array to determine how many strings to concatenate and with which
		//extra words to add. We are only going up to 6 digits.
		if(values.length == 1) {
			numString = onesMap.get(values[0]);
		} else if(values.length == 2) {
			numString = kat.convertTens(values[0], values[1]);
		} else if(values.length == 3) {
			numString = kat.convertHundreds(values[0], values[1], values[2]);
		} else if(values.length == 4) {
			//code
		} else if(values.length == 5) {
			//code
		} else if(values.length == 6) {
			
		}
		return numString;
	}
	
	public String convertTens(int num1, int num2) {
		String numString = "";
		if(num1 == 1) {									//checking if two digit number is a "teen" number, works from 10 to 19.
			numString = teensMap.get(10 + num2);
		} else if(num2 == 0) {							//checking if two digit number ends in 0, i.e. 20, 30, etc.
			numString = doubleDigit.get(num1);
		} else {											//else returning every other number besides the above cases.
		numString = doubleDigit.get(num1) + "-" + onesMap.get(num2);
		}
		return numString;
	}
	
	public String convertHundreds(int num1, int num2, int num3) {
		kat = new KataNumbersToWords();
		String numString = "";
		if(num2 == 0 && num3 == 0) {
			numString = onesMap.get(num1) + " hundred";
		} else {
			numString = onesMap.get(num1) + " hundred and " + kat.convertTens(num2, num3);
		}
		return numString;
	}
	
	public void buildHashMaps() {
		onesMap.put(0, "zero");
		onesMap.put(1, "one");
		onesMap.put(2, "two");
		onesMap.put(3, "three");
		onesMap.put(4, "four");
		onesMap.put(5, "five");
		onesMap.put(6, "six");
		onesMap.put(7, "seven");
		onesMap.put(8, "eight");
		onesMap.put(9, "nine");
		
		teensMap.put(10, "ten");
		teensMap.put(11, "eleven");
		teensMap.put(12, "twelve");
		teensMap.put(13, "thirteen");
		teensMap.put(14, "fourteen");
		teensMap.put(15, "fifteen");
		teensMap.put(16, "sixteen");
		teensMap.put(17, "seventeen");
		teensMap.put(18, "eighteen");
		teensMap.put(19, "nineteen");
		
		doubleDigit.put(2, "twenty");
		doubleDigit.put(3, "thirty");
		doubleDigit.put(4, "forty");
		doubleDigit.put(5, "fifty");
		doubleDigit.put(6, "sixty");
		doubleDigit.put(7, "seventy");
		doubleDigit.put(8, "eighty");
		doubleDigit.put(9, "ninety");
	}
	
}
