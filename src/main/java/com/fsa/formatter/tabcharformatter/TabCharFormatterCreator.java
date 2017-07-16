package com.fsa.formatter.tabcharformatter;

import com.fsa.formatter.Formatter;
import com.fsa.formatter.FormatterCreator;
import com.fsa.formatter.FormatterTypes;

public class TabCharFormatterCreator implements FormatterCreator {

	@Override
	public Formatter createFormatter(FormatterTypes type) {
		Formatter tempFormatter = null;
		switch (type) {
			case  TWOTAB_UPPER:
				tempFormatter = new TwoTabUpperCharFormatter();
					break;
			case TWOTAB_LOWER:	
				tempFormatter = new  TwoTabLowerCharFormatter();
					break;
		}
		
		return tempFormatter;
	}

}
