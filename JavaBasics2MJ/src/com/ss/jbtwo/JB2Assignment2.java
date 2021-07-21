package com.ss.jbtwo;

/**
 * @author Matthew Jackson
 * builds a 2d array and finds max value
 */
public class JB2Assignment2 {

	public static void main(String[] args) {
		double[][] grid = new double[10][10];
		Max2d max = new Max2d();
		
		arrayConstruction(grid);
		max = findmax(grid);
		
		System.out.println("max in array is: " + max.getMax() + " at location [" + max.getMaxLocationX() + "][" + max.getMaxLocationY() + "]" );
		
		//printarray(grid);
	}
	
	static void arrayConstruction(double[][] grid ) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j< grid[i].length; j++) {
				grid[i][j] = Math.random();
			}
		}
	}
	
	static Max2d findmax(double[][] grid) {
		double localmax = 0;
		int x = 0;
		int y = 0;
		Max2d max = new Max2d();
		
		for (int i = 0; i< grid.length; i++) {
			for (int j = 0; j< grid[i].length; j++) {
				if(grid[i][j] > localmax) {
					localmax = grid[i][j];
					x = i;
					y = j;
				}
				
			}
		}
		max.setMax(localmax);
		max.setMaxLocationX(x);
		max.setMaxLocationY(y);
		
		return max;
	}
	
	static void printarray(double[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j< grid[i].length; j++) {
				System.out.print("[" + grid[i][j] + "] ");
			}
			System.out.println();
	}
	
	
	}	
}
