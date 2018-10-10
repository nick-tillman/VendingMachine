package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) {
		

		Scanner inputReader = new Scanner(System.in);
		String sourceFile = "";
		
		boolean done = false;
		File newFile = null;
		while(!done) {
			done = true;
			log("Enter a path to source file: ");
			String path = inputReader.nextLine();
			newFile = new File(path);
			if(newFile.exists()) {
				try (Scanner fileScanner = new Scanner(newFile)) {
					while (fileScanner.hasNextLine()) {
						String line = fileScanner.nextLine();
						sourceFile += line + " ";
					}
				} catch (Exception ex) {
					System.out.println("An exception occurred!");
				}
			} else {
				log("Please enter a valid source file path!");
				done = false;
			}
		}
		
		String searchWord = "";
		
		boolean finished = false;
		while(!finished) {
			finished = true;
			log("Please enter a word to search for: ");
			searchWord = inputReader.nextLine();
			int wordCount = 0;
			if(sourceFile.contains(searchWord)) {
				//maybe a word count?
			} else {
				log("This word was not found inside your source file. Please try again!");
				finished = false;
			}
		}
		
		log("Please enter the word you would live to replace it with: ");
		String replacementWord = inputReader.nextLine();
		
		String changedFile = sourceFile.replace(searchWord, replacementWord);
		log("Please enter a destination directory: ");
		String path = inputReader.nextLine();
		File directory = new File(path);
		File editedFile = new File(directory, newFile.getName());
		try(PrintWriter writer = new PrintWriter(editedFile)) {
			writer.println(changedFile);	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//users/ntillman/repos/exercises/m1-w4d2-file-io-part1-exercises/alices_adventures_in_wonderland.txt

	
	public static void log(String message) {
		System.out.println(message);
	}

}
