package com.ss.jbfive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JB5Lambda1 {

	public static void main(String args[]) {
		String[] items = { "Ford", "Mazda", "BMW", "Morgan", "VW", "Alfa Romeo", "Edsel" };

		Arrays.sort(items, (a, b) -> Integer.compare(a.length(), b.length()));

		System.out.println(Arrays.toString(items));

		Arrays.sort(items, (a, b) -> Integer.compare(b.length(), a.length()));
		System.out.println(Arrays.toString(items));

		Arrays.sort(items, (a, b) -> Integer.compare(a.charAt(0), b.charAt(0)));
		System.out.println(Arrays.toString(items));

		Arrays.sort(items, (a, b) -> {
			if (a.charAt(0) == 'e' || a.charAt(0) == 'E')
				return -1;
			return 1;
		});

		System.out.println(Arrays.toString(items));
		
		
		Arrays.sort(items, (a, b) -> Integer.compare(a.length(), b.length()));
		Arrays.sort(items, (a, b) -> ESort(a, b));
		
		System.out.println(Arrays.toString(items));
		

	}

	static Integer ESort(String a, String b) {
		if (a.charAt(0) == 'e' || a.charAt(0) == 'E')
			return -1;
		return 1;
	}
}
