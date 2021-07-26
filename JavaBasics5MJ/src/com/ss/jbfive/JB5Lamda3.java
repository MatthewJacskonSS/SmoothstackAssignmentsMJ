/**
 * 
 */
package com.ss.jbfive;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mattsdesktop
 *
 */
public class JB5Lamda3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	List<String> myList = new ArrayList<>();
	myList.add("aba");	
	myList.add("abba");	
	myList.add("bba");	
	myList.add("ava");	
	
	myList.stream().filter(p -> (p.charAt(0) == 'a' && p.length()==3)).forEach(meetsReq -> System.out.println(meetsReq));
	}

}
