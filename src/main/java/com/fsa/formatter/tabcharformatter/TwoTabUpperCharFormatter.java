package com.fsa.formatter.tabcharformatter;


import com.fsa.formatter.FormatterTypes;
import com.fsa.formatter.charformtter.factory.CharFormatterFactory;
import com.fsa.formatter.styleFormatter.factory.StyleFormatterFactory;

public class TwoTabUpperCharFormatter extends AbstractTabCharFormatter {

	public TwoTabUpperCharFormatter() {
		super(CharFormatterFactory.getFormatterFactory().createFormatter(FormatterTypes.UPPER),
				StyleFormatterFactory.getStyleFormatterFactory().createFormatter(FormatterTypes.TWOTAB));
		
	}

	/*@Override
	public String format(String inputStr) {
		String formattedString = null;
		formattedString = styleFormatter.format(charFormatter.format(inputStr));	
		return formattedString;
	}*/
	
	
}
