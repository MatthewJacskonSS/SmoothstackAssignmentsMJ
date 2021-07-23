package com.ss.jbfour.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.ss.jbfour.Line;

public class LineTest {
	Line line = new Line(0,0,20,5);
	Line line2 = new Line(-1,-1,20,5);
	Line line3 = new Line (19,4, -1,-1);
	Line line4 = new Line (0,0,0,20);
	Line line5 = new Line (0,0,20,0);
	
	@Test
	public void slopeTest() {
		assertEquals(line.getSlope(), line3.getSlope(), .00001);
		assertEquals(line.getSlope(), .250, .001);
		assertEquals(line2.getSlope(), .286, .001);
		assertThrows(ArithmeticException.class, () -> {line4.getSlope();});
		assertEquals(line5.getSlope(), 0,0);
		
	}
	
	@Test
	public void getDistance(){
		assertEquals(line.getDistance(), 20.616, .001);
		assertEquals(line3.getDistance(), 20.616, .001);
		assertEquals(line2.getDistance(), 21.840, .001);
		assertEquals(line4.getDistance(), 20, 0);
		assertEquals(line5.getDistance(), 20, 0);
	}
	
	@Test
	public void parallelTo() {
		assertTrue(line.parallelTo(line3));
		assertFalse(line.parallelTo(line2));
	}
}
