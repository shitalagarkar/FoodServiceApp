package com.fsa.formatter.charformtter;

import java.util.List;

public class LowerCharFormatter implements CharFormatter{

	@Override
	public String format(String inputString) {
		if (null != inputString && ! inputString.isEmpty()) {
			return inputString.toLowerCase();
		} else
			return null;
	}

	@Override
	public List<String> format(List<String> inputList) {
		/*if(null != inputList && ! inputList.isEmpty()) {
			for (String str : inputList){
				str = str.toLowerCase();
			}
		}*/
		inputList.stream().map(str -> {return str.toLowerCase();});
		return inputList;
		
		
	}

	
}
