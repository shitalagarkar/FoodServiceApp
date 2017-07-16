package com.fsa.formatter.styleFormatter;

import java.util.List;

public class ThreeTabFormatter implements StyleFormatter {
	private final String tab = "\t\t\t"; 
	
	@Override
	public String format(List<String> inputList) {
	
		StringBuilder builder  = new  StringBuilder();
		for (String str : inputList){
			builder.append(str).append(tab);
		}
		
		return builder.toString();
	}

	@Override
	public String format(String inputList) {
		StringBuilder builder  = new  StringBuilder();
		if (null != inputList && !inputList.isEmpty()) {
			builder.append(inputList).append(tab);
		} else {
			builder.append(tab);
		}
		return builder.toString();
	}
	
}
