package com.techelevator;

public class KataStringCalculator {

	
//	public static void main(String[] args) {
//		int result = 0;
//		result = result.add("1:2,3:4,5");
//		
//	}
	
	public int add(String numbers) {
		String[] newArray;
		String str = numbers;
		
		if(str.startsWith("//")) {
			str = str.replace("\n", str.substring(2,3));
			str = str.substring(4);
			newArray = str.split(numbers.substring(2, 3));
		} else {
			str = str.replace("\n", ",");
			newArray = str.split(",");
			System.out.println(str);
		}
		
		int sum = 0;
		for (int i = 0; i < newArray.length; i++) {
			sum+= Integer.parseInt(newArray[i]);
		}
		
		return sum;
	}
}
