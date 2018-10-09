package com.techelevator;

import java.util.HashMap;

public class KataWordsToNumbers {
	private static HashMap<String, Integer> onesMap2 = new HashMap<String, Integer>();
	private static HashMap<String, Integer> tensMap2 = new HashMap<String, Integer>();
	
	public int wordToNumber(String numStr) {
		buildHashMaps();
		int[] tempArray = null;
		if(numStr.contains("-")) {
			String[] tempStrArray = numStr.split("-");
			tempArray = new int[tempStrArray.length];
			for(int i = 0; i < tempStrArray.length; i++) {
				tempArray[i] = Integer.valueOf(tempStrArray[i]);
			}
			
		}
		
	    if (onesMap2.containsKey(numStr)) {   //checking for one-digit values from map
	        return onesMap2.get(numStr);
	    } else if (tensMap2.containsKey(numStr)){    //checking for multiples of 10 < 100
	        return (tensMap2.get(numStr));
	    } else if (tensMap2.containsKey(tempArray[0] * 10) && tensMap2.containsKey(tempArray[1])) {           //checking to see if need to tack ones on
	    		System.out.println(tempArray[1]);
	    		System.out.println("test");
	        return tensMap2.get(tempArray[0]) + tensMap2.get(tempArray[1]);
	    }
	    return 0;
	}
	
	public static void buildHashMaps() {
	    onesMap2.put("zero", 0);
	    onesMap2.put("one", 1);
	    onesMap2.put("two", 2);
	    onesMap2.put("three", 3);
	    onesMap2.put("four", 4);
	    onesMap2.put("five", 5);
	    onesMap2.put("six", 6);
	    onesMap2.put("seven", 7);
	    onesMap2.put("eight", 8);
	    onesMap2.put("nine", 9);
	    
	    tensMap2.put("ten", 10);
	    tensMap2.put("eleven", 11);
	    tensMap2.put("twelve", 12);
	    tensMap2.put("thirteen", 13);
	    tensMap2.put("fourteen", 14);
	    tensMap2.put("fifteen", 15);
	    tensMap2.put("sixteen", 16);
	    tensMap2.put("seventeen", 17);
	    tensMap2.put("eighteen", 18);
	    tensMap2.put("nineteen", 19);
	    
	    tensMap2.put("twenty", 20);
	    tensMap2.put("thirty", 30);
	    tensMap2.put("forty", 40);
	    tensMap2.put("fifty", 50);
	    tensMap2.put("sixty", 60);
	    tensMap2.put("seventy", 70);
	    tensMap2.put("eighty", 80);
	    tensMap2.put("ninety", 90);
	    
	    tensMap2.put("hundred", 100);
	    tensMap2.put("thousand", 1000);
	}
}