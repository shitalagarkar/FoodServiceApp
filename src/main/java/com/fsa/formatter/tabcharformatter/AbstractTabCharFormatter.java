package com.fsa.formatter.tabcharformatter;

import com.fsa.formatter.Formatter;

public abstract class AbstractTabCharFormatter implements Formatter{
	Formatter charFormatter;
	Formatter styleFormatter;
	
	
	
	protected AbstractTabCharFormatter(Formatter charFormatter, Formatter styleFormatter) {
		this.charFormatter = charFormatter;
		this.styleFormatter = styleFormatter;
	}



	public String format(String inputStr) {
		String formattedString = null;
		formattedString = styleFormatter.format(charFormatter.format(inputStr));	
		return formattedString;
	}
}
