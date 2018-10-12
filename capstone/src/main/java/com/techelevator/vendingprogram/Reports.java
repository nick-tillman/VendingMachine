package com.techelevator.vendingprogram;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Reports {
	 private String strDateFormat = "MM/dd/yyyy hh:mm:ss: a";
	 private Date objDate = new Date();
	 private SimpleDateFormat SDF  = new SimpleDateFormat();
	 
	 
	 SDF = new SimpleDateFormat(str);


	
	
	 public static void main(String args[]) {
	  // Instantiate a Date object by invoking its constructor
	  Date objDate = new Date();
	  // Display the Date & Time using toString()
	  System.out.println(objDate.toString());
	  String strDateFormat = "MM/dd/yyyy hh:mm:ss: a";
//	  SDF = new SimpleDateFormat(strDateFormat);
//	  System.out.println(SDF.format(objDate));
	  
	 }

	 public void appendLog() {
	 try(FileWriter fw = new FileWriter("myfile.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println(SDF.format(objDate));
			    System.out.print(SDF.format(objDate));
			    //more code
			    out.println("more text");
			    //more code
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
	 }
	 


	
	public Reports() {
		
   }
	
	
	

	public void log() {
	File newFile = new File("log.txt");
	
	try(PrintWriter writer = new PrintWriter(newFile)) {

		writer.println(newFile);			//Write data to the file buffer.  It will be written to the file when the writer is closed.
	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	


	
	}	
	
}
