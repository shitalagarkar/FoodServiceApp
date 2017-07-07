package com.fsa.model.contract;

import com.fsa.model.ItemCategory;


public interface MenuItem {
	public Double getItemPrice();
	public String getItemName();
	public ItemCategory getItemCategory();
	public Integer getMenuId();
}
