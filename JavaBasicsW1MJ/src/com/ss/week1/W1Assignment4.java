package com.ss.week1;

import java.util.ArrayList;
import java.util.List;

public class W1Assignment4 {
	 public static List<String> noX(List<String> filledX) {
		List<String> notFilledX = new ArrayList<String>();
		for (int i = 0; i < filledX.size(); i++) {
			notFilledX.add(filledX.get(i).replace("x", ""));
		}
		
		return notFilledX;
	}
}
