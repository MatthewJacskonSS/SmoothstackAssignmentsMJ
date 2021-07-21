/**
 * 
 */
package com.ss.jbtwo;

/**
 * @author Mattsdesktop
 *
 */
public class Rectangle implements ShapeA3 {
	float length = 0;
	float height = 0;

	public Rectangle() {
	}

	public Rectangle(float l, float h) {
		length = l;
		height = h;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	@Override
	public float calculateArea() {
		float a = (length * height);
		return a;
	}

	@Override
	public void display() {
		System.out.println("This Rectangle length is: " + length);
		System.out.println("This Rectangle height is: " + height);
		System.out.println("This Rectangle area   is: " + this.calculateArea());
	}

}
