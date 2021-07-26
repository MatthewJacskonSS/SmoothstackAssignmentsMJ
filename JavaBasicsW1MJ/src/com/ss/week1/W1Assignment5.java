package com.ss.week1;

import java.util.Arrays;

public class W1Assignment5 {

	static boolean groupSumClump(int index, int[] inputS, int sum) {
		int[] input = inputS.clone();
		int r = input[0];
		for (int i = 0; i < input.length - 1; i++) {
			if (r == input[i + 1]) {
				;
				input[i + 1] += input[i];
				input[i] = 0;
			} else
				r = input[i + 1];
		}
		Arrays.sort(input);
		boolean out = possibleSum(input, sum);
		return out;
	}

	static boolean possibleSum(int[] input, int sumgoal) {
		int zi = 0;
		int n = input.length;
		for (zi = 0; zi < n; zi++) {
			if (input[zi] == 0)
				continue;
			break;
		}
		// what if negative numbers exist?

		int sum = 0;
		for (int i = zi; i < n; i++) {
			sum += input[i];
			if (sum == sumgoal)
				return true;
		}

		boolean[][] dp = new boolean[n + 1][sum + 1];

		for (int i = 1; i <= n; i++) {
			dp[i][input[i - 1]] = true;
			for (int j = 1; j <= sum; j++) {
				// Sums that were achievable
				// without current array element
				if (dp[i - 1][j] == true) {
					dp[i][j] = true;
					dp[i][j + input[i - 1]] = true;
				}
			}
		}

		for (int j = 0; j <= sum; j++)
			if (dp[n][j] == true) {
				if (j == sumgoal)
				return true;
			}

		return false;
	}

}