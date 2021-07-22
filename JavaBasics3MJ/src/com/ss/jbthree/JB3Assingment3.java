/**
 * 
 */
package com.ss.jbthree;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Matthew Jackson 
 * takes a txt file and counts a character
 */
public class JB3Assingment3 {

	/**
	 * @param args input the character you want to find
	 * only reads the FIRST character
	 */
	public static void main(String[] args) {
		String relativePath = "Resources/input.txt";

		FileReader inputStream = null;
		int count = 0;
		Integer a = null;
		Character b = null;

		try {
			b = args[0].charAt(0);
			a = (int) b;
		} catch (Exception e) {
			System.out.println("No valid input presented");
		}

		try {
			inputStream = new FileReader(relativePath);

			int c;
			while ((c = inputStream.read()) != -1) {
				//Character test = (char)c;
				//System.out.print(test);
				if (c == a) {
					count++;
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Inputed Charachter shows " + count + " times in inputed file");
	}

}
