package com.fsa.model.menu;

import com.fsa.model.ItemCategory;

public class VegMenuItem extends AbstractMenuItem {
	
	public VegMenuItem(Double itemPrice, String itemName, Integer menuId) {
		super(itemPrice, itemName, ItemCategory.VEG, menuId);
	}
	
}
