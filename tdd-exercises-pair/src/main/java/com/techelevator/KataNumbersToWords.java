package com.techelevator;

import java.util.HashMap;

public class KataNumbersToWords {

	
	public String numberToWord(int num) {
		
		HashMap<Integer, String> onesMap = new HashMap<Integer, String>();
		HashMap<Integer, String> tensMap = new HashMap<Integer, String>();
		String number = "";

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
		
		tensMap.put(10, "ten");
		tensMap.put(11, "eleven");
		tensMap.put(12, "twelve");
		tensMap.put(13, "thirteen");
		tensMap.put(14, "fourteen");
		tensMap.put(15, "fifteen");
		tensMap.put(16, "sixteen");
		tensMap.put(17, "seventeen");
		tensMap.put(18, "eighteen");
		tensMap.put(19, "nineteen");
		
		tensMap.put(20, "twenty");
		tensMap.put(30, "thirty");
		tensMap.put(40, "forty");
		tensMap.put(50, "fifty");
		tensMap.put(60, "sixty");
		tensMap.put(70, "seventy");
		tensMap.put(80, "eighty");
		tensMap.put(90, "ninety");
		
		if(num < 1000 && num > 99) {
			int hundredRemainder = num % 100;
				if(hundredRemainder != 0) {
					int firstDigit = num - hundredRemainder;
					number += onesMap.get(firstDigit) + " hundred" + 
				}
			
				if(num < 100 && num > 9) {
					int tens = num % 10;
						if(tens != 0) {
							int firstDigit = num - tens;
							number = tensMap.get(firstDigit) + "-" + onesMap.get(tens);
						} else {
							number = tensMap.get(num);
						}
				}
			
		}
		
		if(num < 100 && num > 9) {
			int tens = num % 10;
				if(tens != 0) {
					int firstDigit = num - tens;
					number = tensMap.get(firstDigit) + "-" + onesMap.get(tens);
				} else {
					number = tensMap.get(num);
				}
		}
		
		for(int value : onesMap.keySet()) {
			if(num == value) {
				return onesMap.get(num);
			}
		}
		System.out.println(number);
		return number;
	}
}
