package com.ss.Service;

public abstract class validate {
	
	
	
	public static boolean validate(String u, String p) {
		if (u.equals("root") && p.equals("root"))
			return true;
		else 
			return false;
	}
}
