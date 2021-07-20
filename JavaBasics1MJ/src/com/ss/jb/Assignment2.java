/**
 * 
 */
package com.ss.jb;

import java.lang.Math;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Matthew Jackson User guessing game
 *
 */
public class Assignment2 {
	public static void main(String[] args) {
		int rand = 1 + (int) (Math.random() * 99);
		int guess = 0;
		boolean result = false;
		// System.out.print(rand); // to cheat with

		for (int i = 0; i < 5; i++) {
			guess = userInput();
			result = verification(guess, rand);
			if (result == true)
				break;
			System.out.println("Guess again");
		}

		endgame(result, rand);

	}

	static int userInput() {
		int i = 0;
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		do {

			System.out.println("Enter Guess [1-100]: ");
			try {
				i = myObj.nextInt();
			} catch (InputMismatchException e) {
				myObj.next();
				System.out.print("That’s not " + "an integer. Try again: ");
			}
			if (i < 1 || i > 100) {
				i = 0;
				System.out.println("Please Enter Valid Number");
			}
		} while (i == 0);
	return i;

	}

	static boolean verification(int guess, int rand) {
		if (rand < guess - 10 || rand > guess + 10)
			return false; // if rand is outside range, return wrong
		return true;
	}

	static void endgame(boolean result, int rand) {
		if (result == true)
			System.out.println("Congrats, the correct answer was: " + rand);
		else
			System.out.println("Sorry, the correct answer was: " + rand);
	}
}
