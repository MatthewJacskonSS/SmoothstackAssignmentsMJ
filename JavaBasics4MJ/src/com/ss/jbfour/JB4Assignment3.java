package com.ss.jbfour;

public class JB4Assignment3 {

	
	static int index = 2500;
	static boolean race = true;
	public static void main(String args[]) {
		Integer boundedBuffer[] = new Integer[5000];
	

		Runnable producer = new Runnable() {

			@Override
			public void run() {
				while (race = true) {
					if (index >= boundedBuffer.length-1) {
						race = false;
						break;
					}
					Integer i = (int) (Math.random() * 10);
					boundedBuffer[index] = i;
					index++;

				}
			}

		};

		Runnable consumer = new Runnable() {

			@Override
			public void run() {
				while (race == true) {
					if (index <= 0) {
						race = false;
						break;
					}
					System.out.println(boundedBuffer[index] + " at index: " + index);
					index--;
				}

			}

		};
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);
		t1.start();
		t2.start();
	}

}
