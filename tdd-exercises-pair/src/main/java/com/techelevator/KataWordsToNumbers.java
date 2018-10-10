package com.techelevator;

import java.util.HashMap;

public class KataWordsToNumbers {
	
	private static HashMap<String, Integer> valueMap = new HashMap<String, Integer>();
	
	
	public int wordToNumber(String numString) {
		
		buildHashMaps();
		int num = 0;
		
		if(numString.contains("thousand")) {
			num = convertThousands(numString);
		} else if(numString.contains("hundred")) {
			num = convertHundreds(numString);
		} else {
			num = singleAndDoubleDigits(numString);
		}
		return num;
	}
	
	
	
	
	
	public static int singleAndDoubleDigits(String numString) {
		int num = 0;
		
		//first if check is for hyphenated words, i.e. fifty-five. Will split words into an array and then retrieve
		//the values and add them. If no hyphen, we assume a single digit and return that digit.
		if(numString.contains("-")) {
			String[] stringArray  = numString.split("-");
			num = valueMap.get(stringArray[0]) + valueMap.get(stringArray[1]);
		} else {
			num = valueMap.get(numString);
		}
		return num;
	}
	
	public static int convertHundreds(String numString) {
		int num = 0;
		
		//this code is removing spaces (if present) and the word "and" from our string so our key values can 
		//be passed. It then splits the string into an array on the word "hundred".
		if(numString.startsWith(" ")) {
			numString = numString.replaceFirst(" ", "");
		}
		if(numString.contains("and")) {
			numString = numString.replace(" and ", "");
		}
		String[] stringArray = numString.split(" hundred");
		
		
		//first if check checks if the array only holds one string after the split, i.e. one hundred, two hundred. It
		//then finds that value and multiplies by 100 to get the correct integer value. If that check fails we know
		//we have more than 1 digit with 2 zeros. We do the same calculation as above and then pass the remaining
		//string to our singleAndDoubleDigits method to retrieve and add.
		if(stringArray.length == 1) {
			num = valueMap.get(stringArray[0]) * 100;
		} else {
			num = (valueMap.get(stringArray[0]) * 100) + singleAndDoubleDigits(stringArray[1]);
		}
		return num;
		
	}
	
	public static int convertThousands(String numString) {
		int num = 0;
		
		//this code is removing the word "and" from our string so our key values can be passed. It
		//then splits the string into an array on the word "thousand".
		if(numString.contains("and")) {
			numString = numString.replace(" and ", "");
		}
		String[] stringArray = numString.split(" thousand");
		
		
		
		if(stringArray.length == 1) {
			if(stringArray[0].contains("-")) {
				String[] tempArray = stringArray[0].split("-");
				num = valueMap.get(tempArray[0]) + valueMap.get(tempArray[1]) * 1000;
			} else {
				num = valueMap.get(stringArray[0]) * 1000;
			}
		} else {
			
			if(stringArray[1].contains("hundred")) {
				num = (valueMap.get(stringArray[0]) * 1000) + convertHundreds(stringArray[1]);
			} else {
				num = (valueMap.get(stringArray[0]) * 1000) + singleAndDoubleDigits(stringArray[1]);
			}
		}
		return num;
	}
	
	public static void buildHashMaps() {
		valueMap.put("zero", 0);
	    valueMap.put("one", 1);
	    valueMap.put("two", 2);
	    valueMap.put("three", 3);
	    valueMap.put("four", 4);
	    valueMap.put("five", 5);
	    valueMap.put("six", 6);
	    valueMap.put("seven", 7);
	    valueMap.put("eight", 8);
	    valueMap.put("nine", 9); 
	    valueMap.put("ten", 10);
	    valueMap.put("eleven", 11);
	    valueMap.put("twelve", 12);
	    valueMap.put("thirteen", 13);
	    valueMap.put("fourteen", 14);
	    valueMap.put("fifteen", 15);
	    valueMap.put("sixteen", 16);
	    valueMap.put("seventeen", 17);
	    valueMap.put("eighteen", 18);
	    valueMap.put("nineteen", 19);
	    valueMap.put("twenty", 20);
	    valueMap.put("thirty", 30);
	    valueMap.put("forty", 40);
	    valueMap.put("fifty", 50);
	    valueMap.put("sixty", 60);
	    valueMap.put("seventy", 70);
	    valueMap.put("eighty", 80);
	    valueMap.put("ninety", 90);
	}
}