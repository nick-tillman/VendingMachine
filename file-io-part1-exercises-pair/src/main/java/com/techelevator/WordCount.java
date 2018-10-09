package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class WordCount {
	
	private static Scanner inputReader = new Scanner(System.in);

	public static void main(String[] args) {
		
		File inputFile = getFileFromUser();
		int wordCount = 0;
		int sentenceCount = 0;
		String book = "";
		
		try (Scanner fileScanner = new Scanner(inputFile)) {
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				book += line + " ";
			}
			
		} catch (Exception ex) {
			System.out.println("An exception occurred!");
		}
//		book = book.replace("*", " ");
//		book = book.replace("·", " ");
//		book = book.replace("]", " ");
//		book = book.replace("[", " ");
//		book = book.replace("_", " ");
//		book = book.replace("\"", " ");
//		book = book.replace("(", " ");
//		book = book.replace(")", " ");
//		book = book.replace(",", " ");
//		book = book.replace(";", " ");
//		book = book.replace(":", " ");
//		book = book.replace(">", " ");
//		book = book.replace("<", " ");
//		book = book.replace("%", " ");
//		book = book.replace("#", " ");
//		book = book.replace("@", " ");
//		book = book.replace("&", " ");
//		//book = book.replace("--", " ");
//
//		book = book.replace("      ", " ");
//		book = book.replace("     ", " ");
//		book = book.replace("    ", " ");
//		book = book.replace("   ", " ");
//		book = book.replace("  ", " ");
		String[] newArray = book.split(" ");
		wordCount = newArray.length;
		System.out.println(book);
}
	
	//users/ntillman/repos/exercises/m1-w4d2-file-io-part1-exercises/alices_adventures_in_wonderland.txt

	
	public static File getFileFromUser() {
		System.out.println("Enter path of the txt file: ");
		String path = inputReader.nextLine();
		File quiz = new File(path);
		return quiz;
	}
}
