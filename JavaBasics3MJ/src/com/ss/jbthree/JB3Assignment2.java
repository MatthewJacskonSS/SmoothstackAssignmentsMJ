package com.ss.jbthree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author Matthew Jackson
 * appends whatever string is put into the arguments
 * 
 */

public class JB3Assignment2 {

	
	public static void main(String args[]) {
	try (
		FileWriter fw = new FileWriter("Resources/output.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter out = new PrintWriter(bw);)
	{
		
		out.println("Testing");
		
	} catch (IOException e) {
		System.out.println("File write failed");
	}
	
}
}