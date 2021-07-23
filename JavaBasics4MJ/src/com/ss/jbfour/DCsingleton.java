package com.ss.jbfour;

public class DCsingleton {
	private static DCsingleton instance;

	public static DCsingleton getInstance() {
		 if (instance == null){			//multiple threads can hit this branch at once at once
			 synchronized (DCsingleton.class){ //if branched here, only one thread can go move forward
				 if (instance == null){  
						 instance = new DCsingleton(); //the one thread that got here makes the new instance and no other threads can make it to this step
					 }
				 }
			 }
		return instance;
		 }
}
