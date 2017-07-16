package com.fsa.formatter.tabcharformatter;

import com.fsa.formatter.FormatterTypes;
import com.fsa.formatter.charformtter.factory.CharFormatterFactory;
import com.fsa.formatter.styleFormatter.factory.StyleFormatterFactory;

public class TwoTabLowerCharFormatter extends AbstractTabCharFormatter {
	
	public TwoTabLowerCharFormatter() {
		super(CharFormatterFactory.getFormatterFactory().createFormatter(FormatterTypes.LOWER),
				StyleFormatterFactory.getStyleFormatterFactory().createFormatter(FormatterTypes.TWOTAB));
		
	}

	/*@Override
	public String format(String inputStr) {
		String formattedString = null;
		formattedString = styleFormatter.format(charFormatter.format(inputStr));	
		return formattedString;
	}*/
}
