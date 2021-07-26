package com.ss.week1;

import java.util.Arrays;
import java.util.List;

public class Assignment4test {

	public static void main(String[] args) {
		String[] array = {"x"}; 
		List<String> filledX = Arrays.asList(array);
		List<String> notX = W1Assignment4.noX(filledX);
		
		System.out.println(notX);

	}

}
