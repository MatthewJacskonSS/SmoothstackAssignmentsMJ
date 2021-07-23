package com.ss.jbfour;


public class DeadLock {

	public static void main(String[] args) {
		Integer m1 = new Integer(3);
		Integer m2 = new Integer(3);

		System.out.println("Deadlock example -> start");
		Runnable t1 = new Runnable() {

			@Override
			public void run() {
				try {
					synchronized (m1) {
						Thread.sleep(100);
						synchronized (m2) {
							System.out.println("Thread 1 is running - has 2 locks");
						}
					}
				} catch (Exception e) {
				}
			}
		};
		Runnable t2 = new Runnable() {
			@Override
			public void run() {
				try {
					synchronized (m2) {
						Thread.sleep(100);
						synchronized (m1) {
							System.out.println("Thread 2 is running - has 2 locks");
						}
					}
				} catch (Exception e) {
				}
			}
		};

		new Thread(t1).start();
		new Thread(t2).start();
		System.out.println("Deadlock example -> end");
	}

}