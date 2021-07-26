/**
 * 
 */
package com.ss.jbfive;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Matthew Jackson
 *
 */
public class JB5Lamda2 {

	/**
	 * @param
	 */
	public static void main(String[] args) {
		List<Integer> items = Arrays.asList(1, 3, 44);

		System.out.print(evenodd(items));

	}

	static String evenodd(List<Integer> items) {
		StringBuilder s = new StringBuilder("");
		for (Integer i : items) {
			if (i % 2 == 0) {
				s.append("e" + i.toString() + ", ");
			}
			else {
				s.append("o"  + i.toString() + ", ");
			}
		}
		s.deleteCharAt(s.lastIndexOf(","));
			// could have used stringJoiner from Java8
		return s.toString();
	}

}
