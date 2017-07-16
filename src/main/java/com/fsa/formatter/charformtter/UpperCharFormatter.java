package com.fsa.formatter.charformtter;

import java.util.List;

public class UpperCharFormatter implements CharFormatter {

	@Override
	public String format(String inputString) {
		if (null != inputString && ! inputString.isEmpty()) {
			return inputString.toUpperCase();
		}
		return null;
	}
	@Override
	public List<String> format(List<String> inputList) {
		if(null != inputList && ! inputList.isEmpty()) {
			for (String str : inputList){
				if (null != str && ! str.isEmpty()) {
					str = str.toUpperCase();
				}
				
			}
		}
		return inputList;
	}
	
}
