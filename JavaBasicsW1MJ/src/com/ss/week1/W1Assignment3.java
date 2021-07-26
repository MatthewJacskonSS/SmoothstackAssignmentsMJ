package com.ss.week1;

import java.util.ArrayList;
import java.util.List;

public class W1Assignment3 {

	public static List<Integer> doubling(List<Integer> toBeDoubled) {
		List<Integer> doubled = new ArrayList<Integer>();
		for(Integer i: toBeDoubled) {
			doubled.add(i*2);
		}
		
		
		return doubled;
	}
}
