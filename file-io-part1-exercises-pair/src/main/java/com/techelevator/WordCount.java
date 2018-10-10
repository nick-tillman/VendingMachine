package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class WordCount {
	
	private static String book;
	
	private static Scanner inputReader = new Scanner(System.in);

	public static void main(String[] args) {
		
		File inputFile = getFileFromUser();
		int wordCount = 0;
		int sentenceCount = 0;
		book = "";
		
		try (Scanner fileScanner = new Scanner(inputFile)) {
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				book += line + " ";
			}
		} catch (Exception ex) {
			System.out.println("An exception occurred!");
		}
		
		trim();
		String[] wordArray = book.split(" ");
		String[] sentenceArray = book.split("\\.");
		
		wordCount = wordArray.length;
		sentenceCount = sentenceArray.length;
		System.out.println();
		System.out.println(wordCount + " words in document.");
		System.out.println(sentenceCount + " sentences in document.");

}
	
	//users/ntillman/repos/exercises/m1-w4d2-file-io-part1-exercises/alices_adventures_in_wonderland.txt

	
	public static File getFileFromUser() {
		System.out.println("Enter path of the txt file: ");
		String path = inputReader.nextLine();
		File quiz = new File(path);
		return quiz;
	}
	
	public static void trim() {
		book = book.replace("!", ".");
		book = book.replace("?", ".");
		book = book.replace("----", "");
		book = book.replace("--", "");
		book = book.replace("- ", "-");
		book = book.replace(" -", "-");
		book = book.replace("*", " ");
		book = book.replace("·", " ");
		book = book.replace("]", " ");
		book = book.replace("[", " ");
		book = book.replace("_", " ");
		book = book.replace("\"", " ");
		book = book.replace("(", " ");
		book = book.replace(")", " ");
		book = book.replace(",", " ");
		book = book.replace(";", " ");
		book = book.replace(":", " ");
		book = book.replace(">", " ");
		book = book.replace("<", " ");
		book = book.replace("%", " ");
		book = book.replace("#", " ");
		book = book.replace("@", " ");
		book = book.replace("&", " ");
		book = book.replace("      ", " ");
		book = book.replace("     ", " ");
		book = book.replace("    ", " ");
		book = book.replace("   ", " ");
		book = book.replace("  ", " ");
	}
}
