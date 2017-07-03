package com.fsa.model.menu;

import com.fsa.model.ItemCategory;

public class NonVegMenuItem extends AbstractMenuItem {

	
	
	public NonVegMenuItem(Double itemPrice, String itemName, Integer menuId) {
		super(itemPrice, itemName, ItemCategory.NONVEG, menuId);
	}


}
