package com.fsa.model.menu;

import com.fsa.model.ItemCategory;
import com.fsa.model.contract.MenuItem;

public abstract class AbstractMenuItem implements MenuItem {

	private Integer menuId;
		private Double itemPrice;
	private String itemName;
	private ItemCategory category;
	

	protected AbstractMenuItem(Double itemPrice, String itemName, ItemCategory category, Integer menuId) {
		this.itemPrice = itemPrice;
		this.itemName = itemName;
		this.category = category;
		this.menuId = menuId;
	}
	
	public Integer getMenuId() {
		return menuId;
	}
	
	public Double getItemPrice() {
		return itemPrice;
	}

	public String getItemName() {
		return itemName;
	}


	public ItemCategory getItemCategory() {
		return category;
	}

	

}

