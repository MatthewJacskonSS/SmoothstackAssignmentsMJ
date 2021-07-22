package com.ss.jbthree;

import java.io.File;

/**
 * @author Matthew Jackson
 * Prints out files and folders in a given directory
 * 
 */

public class JB3Assingment1 {
	public static void main(String args[]) {
		try {
			File file = new File("src/com/ss/jbthree");
			String[] fileList = file.list();
			for (String name : fileList) {
				System.out.println(name);
			}
		} catch (Exception e) {
			System.out.println("Folder not found");
		}
	}
}