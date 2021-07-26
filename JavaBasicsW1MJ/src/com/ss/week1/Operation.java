package com.ss.week1;

import java.util.function.Function;

public interface Operation extends Function<Integer, String>{
	public String operation(Integer a);
}
