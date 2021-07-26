package com.ss.week1;

import java.sql.Connection;

public class SampleSingleton {

	private static Connection conn = null;

	private static SampleSingleton instance = null;

	public static SampleSingleton getInstance() {
		if (instance == null) {
			synchronized (SampleSingleton.class) {
				if (instance == null) {
					instance = new SampleSingleton();
					//set conn equal to something;
				}
			}
		}
		return instance;

	}
}
