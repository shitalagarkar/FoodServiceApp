package com.fsa.formatter.styleFormatter.factory;

import com.fsa.formatter.FormatterCreator;
import com.fsa.formatter.FormatterTypes;
import com.fsa.formatter.styleFormatter.StyleFormatter;
import com.fsa.formatter.styleFormatter.ThreeTabFormatter;
import com.fsa.formatter.styleFormatter.TwoTabFormatter;

public class StyleFormatterFactory implements FormatterCreator {
	public static volatile StyleFormatterFactory factory = null;
	
	private StyleFormatterFactory(){}
	
	public static StyleFormatterFactory getStyleFormatterFactory () {
		if (null == factory) {
			synchronized (StyleFormatterFactory.class) {
				if (null == factory) {
					factory = new StyleFormatterFactory();
				}
			}
		}
		
		return factory;
	}
	
	public StyleFormatter createFormatter (FormatterTypes style) {
		StyleFormatter formatter = null;
		switch (style) {
			case  TWOTAB:
				formatter = new TwoTabFormatter();
				break;
			case THREETAB:
				formatter = new ThreeTabFormatter();
				break;
			default:
				formatter = new TwoTabFormatter();
		}
		
		return formatter;
		
	}
	
	
}
