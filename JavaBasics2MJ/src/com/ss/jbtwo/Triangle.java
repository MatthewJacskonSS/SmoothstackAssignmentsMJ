package com.ss.jbtwo;

public class Triangle implements ShapeA3 {
	
	private float length = 0;
	private float height = 0;
	
	public Triangle() {
	}

	public Triangle(float l, float h) {
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
		float a = (length * height)/2;
		return a;
	}

	@Override
	public void display() {
		System.out.println("This triangle length is: " + length);
		System.out.println("This triangle height is: " + height);
		System.out.println("This triangle area   is: " + this.calculateArea());

	}

}
