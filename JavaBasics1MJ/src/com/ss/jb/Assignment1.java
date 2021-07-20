package com.ss.jb;

/**
 * loop patterns
 * @author Matthew Jackson
 */
public class Assignment1 {
	public static void main(String[] args) {
		System.out.println("1)");
		leftTree(4);
		System.out.println("2)");
		udLeftTree(4);
		System.out.println("3)");
		centerTree(4);
		System.out.println("4)");
		udCenterTree(4);

	}

	static void leftTree(int s) {
		for (int j = 1; j <= s; j++) {
			for (int i = 1; i <= j; i++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println(".........");
	}

	static void udLeftTree(int s) {
		System.out.println("..........");
		for (int i = 1; i <= s; i++) {
			for (int j = i; j <= s; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	static void centerTree(int s) {
		for (int i = 1; i <= s; i++) {
			for (int j = i; j <= s + 1; j++) {
				System.out.print(" ");
			}

			for (int j = 1; j <= (2 * i - 1); j++) {
				System.out.print("*");
			}

			System.out.println("");
		}
		System.out.println("...........");
	}

	static void udCenterTree(int s) {
		System.out.println("............");
		for (int i = 1; i <= s; i++) {
			System.out.print("  ");
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}

			for (int j = 1; j <= (s * 2 - (2 * i - 1)); j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}