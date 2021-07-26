package com.ss.week1;

import java.util.Arrays;
import java.util.List;

public class Assignment3test {

	public static void main(String[] args) {
		Integer[] array = {10,0};
		List<Integer> toBeDoubled = Arrays.asList(array);
		List<Integer> doubled = W1Assignment3.doubling(toBeDoubled);
		
		System.out.println(doubled);
		
		List<Integer> rightmost = W1Assignment2.rightDigit(toBeDoubled);
		
		System.out.println(rightmost);
	}

}
