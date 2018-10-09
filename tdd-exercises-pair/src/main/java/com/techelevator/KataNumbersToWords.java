package com.techelevator;

import java.util.HashMap;

public class KataNumbersToWords {
	
	private static HashMap<Integer, String> onesMap = new HashMap<Integer, String>();
	private static HashMap<Integer, String> teensMap = new HashMap<Integer, String>();
	private static HashMap<Integer, String> doubleDigit = new HashMap<Integer, String>();

	public String numberToWord(int num) {

		buildHashMaps();
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
			numString = convertSingleDigit(values[0]);
		} else if(values.length == 2) {
			numString = convertTens(values[0], values[1]);
		} else if(values.length == 3) {
			numString = convertHundreds(values[0], values[1], values[2]);
		} else if(values.length == 4) {
			numString = convertThousands(values[0], values[1], values[2], values[3]);
		} else if(values.length == 5) {
			numString = convertTenThousands(values[0], values[1], values[2], values[3], values[4]);
		} else if(values.length == 6) {
			numString = convertHundredThousands(values[0], values[1], values[2], values[3], values[4], values[5]);
		}
		return numString;
	}
	
	public static String convertSingleDigit(int index0) {
		String numString = "";
		numString = onesMap.get(index0);
		return numString;
	}
	
	public static String convertTens(int index0, int index1) {
		String numString = "";
		if(index0 == 0) {											//checking if 2 digit number is really a single digit number, i.e. 01, 02, etc.
			numString = convertSingleDigit(index1);
		} else if(index0 == 1) {										//checking if 2 digit number is a "teen" number, works from 10 to 19.
			numString = teensMap.get(10 + index1);
		} else if(index1 == 0) {										//checking if 2 digit number ends in 0, i.e. 20, 30, etc.
			numString = doubleDigit.get(index0);
		} else {														//else returning every other number besides the above cases.
			numString = doubleDigit.get(index0) + "-" + onesMap.get(index1);
		}
		return numString;
	}
	
	public static String convertHundreds(int index0, int index1, int index2) {
		String numString = "";
		if(index0 == 0 && index1 == 0) {								//checking if 3 digit number is really a single digit number, i.e. 001, 002, etc.
			numString = "and " + convertSingleDigit(index2);
		} else if(index1 == 0 && index2 == 0) {						//checking if 3 digit number ends in zeros, i.e. 100, 200, etc.
			numString = onesMap.get(index0) + " hundred";
		} else {														//else getting the hundreds digit and passing our convertTens method the rest of the digits
			numString = onesMap.get(index0) + " hundred and " + convertTens(index1, index2);
		}
		return numString;
	}
	
	public static String convertThousands(int index0, int index1, int index2, int index3) {
		String numString = "";
		if(index1 == 0 && index2 == 0 && index3 == 0) { 				//checking if 4 digit number ends in 3 zeros, i.e. 1000, 2000, etc.
			numString = onesMap.get(index0) + " thousand";
		} else if(index1 == 0 && index2 != 0) {						//checking if 4 digit number has no hundreds but does have tens, i.e. 1025, 3011, etc.
			 numString = onesMap.get(index0) + " thousand and " + convertTens(index2, index3);
		} else {														//else getting the thousands digit and passing the rest to convertHundreds.
			numString = onesMap.get(index0) + " thousand " + convertHundreds(index1, index2, index3);
		}
		return numString;
	}
	
	public static String convertTenThousands(int index0, int index1, int index2, int index3, int index4) {
		String numString = "";
		if(index0 != 1 && index1 == 0 && index2 ==0 && index3 == 0 && index4 == 0) {		//checking if 5 digit number does NOT start with 1 and does ends in zeros, i.e. 20000, 30000, etc.
			numString = doubleDigit.get(index0) + " thousand";
		} else if(index0 == 1 && index2 == 0 && index3 == 0 && index4 == 0) {				//checking if 5 digit number starts with 1 and ends in 3 zeros, i.e. 11000, 15000, etc. INCLUDES 10000!!
			numString = teensMap.get(10 + index1) + " thousand";
		} else if(index0 == 1) {															//checking if 5 digit number begins with one, i.e. 10359, 15391, etc.
			numString = teensMap.get(10 + index1) + " thousand " + convertHundreds(index2, index3, index4);
		} else if(index0 != 1 && index1 == 0){											//checking if 5 digit number does NOT start with one and index 1 is a zero, i.e. 20367, 40592, etc.
			numString = doubleDigit.get(index0) + " thousand " + convertHundreds(index2, index3, index4);
		} else {																			//else getting the rest of the cases not covered above.
			numString = doubleDigit.get(index0) + "-" + onesMap.get(index1) + " thousand " + convertHundreds(index2, index3, index4);
		}
		return numString;
	}
	
	public static String convertHundredThousands(int index0, int index1, int index2, int index3, int index4, int index5) {
		String numString = "";
		if(index1 == 0 && index2 == 0 && index3 == 0 && index4 == 0 && index5 == 0) {		//checking 6 digit number if ends with zeros, i.e. 100000, 200000, etc.
			numString = onesMap.get(index0) + " hundred thousand";
		} else if(index1 == 0 && index2 == 0 && index3 ==0) {
			numString = onesMap.get(index0) + " hundred thousand and " + convertTens(index4, index5);
		} else if(index1 == 0 & index2 == 0) {											//checking 6 digit number if index 1 and 2 are zeros, i.e. 100345, 200986, etc.
			numString = onesMap.get(index0) + " hundred thousand " + convertHundreds(index3, index4, index5);
		} else if(index2 == 0 && index3 == 0) {
			numString = onesMap.get(index0) + " hundred " + doubleDigit.get(index1) + " thousand and " + convertTens(index4, index5);
		} else if(index1 == 0) {
			numString = onesMap.get(index0) + " hundred and " + convertThousands(index2, index3, index4, index5);
		} else {																			//else getting all over cases not covered above.
			numString = onesMap.get(index0) + " hundred " + convertTenThousands(index1, index2, index3, index4, index5);
		}
		return numString;
	}
	
	public static void buildHashMaps() {
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
