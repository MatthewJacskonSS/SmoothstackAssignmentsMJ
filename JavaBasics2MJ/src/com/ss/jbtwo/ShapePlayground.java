/**
 * 
 */
package com.ss.jbtwo;

/**
 * @author Mattsdesktop
 *
 */
public class ShapePlayground {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Circle cone = new Circle(2);
		Circle ctwo = new Circle();
		Circle cthree = new Circle(10);

		Triangle tone = new Triangle(0,0);
		Triangle ttwo = new Triangle(1,1);
		Triangle tthree = new Triangle();
		
		Rectangle rone = new Rectangle(0,0);
		Rectangle rtwo = new Rectangle(2,2);
		Rectangle rthree = new Rectangle();
		
		cone.display();
		ctwo.display();
		cthree.display();
		
		tone.display();
		ttwo.display();
		tthree.display();
		
		rone.display();
		rtwo.display();
		rthree.display();
		
	}

}
