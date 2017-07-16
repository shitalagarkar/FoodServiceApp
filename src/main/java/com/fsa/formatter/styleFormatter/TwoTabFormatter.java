package com.fsa.formatter.styleFormatter;

import java.util.List;

public class TwoTabFormatter implements StyleFormatter {
	private final String tab = "\t\t";
	
	@Override
	public String format(List<String> inputList) {
	
		StringBuilder builder  = new  StringBuilder(
				);
		for (String str : inputList){
			builder.append(str).append(tab);
		}
		
		return builder.toString();
	}

	@Override
	public String format(String inputList) {
		StringBuilder builder  = new  StringBuilder();
		builder.append(tab);
		if (null != inputList && !inputList.isEmpty()) {
			builder.append(inputList).append(tab);
		} /*else {
			builder.append(tab);
		}*/
		return builder.toString();
	}
	
	
	
}
