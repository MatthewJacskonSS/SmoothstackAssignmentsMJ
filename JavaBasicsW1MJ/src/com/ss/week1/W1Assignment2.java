package com.ss.week1;

import java.util.ArrayList;
import java.util.List;

public class W1Assignment2 {
	
	public static List<Integer> rightDigit(List<Integer> allDigits){
	List<Integer> rightmost = new ArrayList<Integer>();
	for(Integer i: allDigits) {
		 rightmost.add(i%10);
	}
	
	return rightmost;
}
}
