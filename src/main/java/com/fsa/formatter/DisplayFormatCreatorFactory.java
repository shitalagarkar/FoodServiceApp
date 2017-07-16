package com.fsa.formatter;

import com.fsa.formatter.charformtter.factory.CharFormatterFactory;
import com.fsa.formatter.styleFormatter.factory.StyleFormatterFactory;
import com.fsa.formatter.tabcharformatter.TabCharFormatterCreator;

public class DisplayFormatCreatorFactory {
	private static volatile DisplayFormatCreatorFactory factory = null;
	
	public static DisplayFormatCreatorFactory getFormatCreatorFactory () {
		if (null == factory) {
			synchronized (DisplayFormatCreatorFactory.class) {
				if (null == factory) {
					factory = new DisplayFormatCreatorFactory();
				}
			}
		}
		
		return factory;
	}
	
	public FormatterCreator createFormatter (FormatCreatorTypes creatorTypes) {
		FormatterCreator creator = null;
		switch(creatorTypes) {
			case TAB_CHAR:
					creator =new TabCharFormatterCreator();
					break;
			case TAB:
					creator = StyleFormatterFactory.getStyleFormatterFactory();
					break;
			case CHAR:	
					creator = CharFormatterFactory.getFormatterFactory();
					break;
			default:
					creator =CharFormatterFactory.getFormatterFactory();
			}
		
		return creator;
	}
	
}
