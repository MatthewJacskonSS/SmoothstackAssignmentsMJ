/**
 * 
 */
package com.ss.jbtwo;

/**
 * @author Matthew Jackson
 * Takes double precisions floating point values from CLI arguments and adds them together
 */
public class JB2Assignment1 {

	/**
	 * @param args n ammount of doubles
	 */
	public static void main(String[] args) {
		double results = 0;
		Double holdvalue = null;
		
		for (String input: args) {
			try{
				holdvalue = Double.valueOf(input);
			//	System.out.print(holdvalue.toString()); 
			}
			catch(NumberFormatException e) {
				continue;
			}
			try {
				results += holdvalue;
			}
			catch(NullPointerException e) {
				continue;
			}
		}
		System.out.println("Sum of all inputs is : " + results);
	}

}
