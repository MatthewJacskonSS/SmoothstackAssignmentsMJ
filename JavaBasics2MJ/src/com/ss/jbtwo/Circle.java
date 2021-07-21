/**
 * 
 */
package com.ss.jbtwo;

/**
 * @author Mattsdesktop
 *
 */
public class Circle implements ShapeA3 {

	float diameter = 0;

	public Circle() {
	}

	public Circle(float d) {
		diameter = d;
	}

	public float getDiameter() {
		return diameter;
	}

	public void setDiameter(float diameter) {
		this.diameter = diameter;
	}

	@Override
	public float calculateArea() {
		float r = diameter / 2;
		float a = (float) (Math.PI * Math.pow(r, 2));
		return a;
	}

	@Override
	public void display() {
		System.out.println("This circles diameter is: " + diameter);
		System.out.println("This circles area   is: " + this.calculateArea());

	}

}
