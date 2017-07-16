package com.fsa.formatter.charformtter;

import java.util.List;

import com.fsa.formatter.Formatter;

public interface CharFormatter extends Formatter {
//	public String format(String inputString);
	public List<String> format(List<String> inputList);
}
