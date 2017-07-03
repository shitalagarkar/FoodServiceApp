package com.fsa.model.menu.factory;

import com.fsa.model.ItemCategory;
import com.fsa.model.contract.MenuItem;
import com.fsa.model.menu.NonVegMenuItem;
import com.fsa.model.menu.VegMenuItem;

public class MenuItemFactory {

	private volatile static MenuItemFactory factory = null;
	
	private MenuItemFactory() {		
	}
	
	public static MenuItemFactory getFactory (){
		if (null == factory) {
			synchronized (MenuItemFactory.class) {
				if(null == factory) {
					factory = new MenuItemFactory();
				}
			}
			
		}
		return factory;
	}
	
	public MenuItem createMenuItem(ItemCategory category, String itemName, Double price, Integer menuId) {
		MenuItem item = null;
		switch(category){
			case NONVEG :
				item = new NonVegMenuItem(price, itemName,menuId );
			case VEG:
				item= new VegMenuItem(price, itemName,menuId);
			default:
				item = new VegMenuItem(price, itemName, menuId);
		}
		return item;
	}
}
