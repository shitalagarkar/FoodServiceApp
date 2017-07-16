package com.fsa.formatter.charformtter.factory;

import com.fsa.formatter.Formatter;
import com.fsa.formatter.FormatterCreator;
import com.fsa.formatter.FormatterTypes;

import com.fsa.formatter.charformtter.CharFormatter;
import com.fsa.formatter.charformtter.LowerCharFormatter;
import com.fsa.formatter.charformtter.UpperCharFormatter;

public class CharFormatterFactory implements FormatterCreator {
	private static volatile CharFormatterFactory charFactory;
	
	private CharFormatterFactory(){}
	


	public static CharFormatterFactory getFormatterFactory () {
		if (null == charFactory) {
			synchronized (CharFormatterFactory.class) {
				if (null == charFactory) {
					charFactory = new CharFormatterFactory();
				}
			}
		}
		
		return charFactory;
	}
	
	@Override
	public Formatter createFormatter (FormatterTypes format) {
		CharFormatter formatter = null;
		switch (format) {
		case UPPER:
				formatter = new UpperCharFormatter();
				break;
		case LOWER:
			formatter = new LowerCharFormatter();
				break;
			default:
				formatter = new LowerCharFormatter();
		}
		return formatter;
	}
	
}
