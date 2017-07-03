package com.fsa.model.menu;

import com.fsa.model.ItemCategory;

public class SelectedMenu implements com.fsa.model.contract.SelectedMenuItem {
	private Integer qty;
	private Integer menuId;
	private Double itemPrice;
	private String itemName;
	
	public SelectedMenu(Integer qty, Integer menuId, Double itemPrice, String itemName, ItemCategory category) {
		super();
		this.qty = qty;
		this.menuId = menuId;
		this.itemPrice = itemPrice;
		this.itemName = itemName;
	}

	@Override
	public Double getItemPrice() {
		return itemPrice;
	}

	@Override
	public String getItemName() {
		return itemName;
	}

	@Override
	public ItemCategory getItemCategory() {
		return null;
	}

	@Override
	public Integer getMenuId() {
		return menuId;
	}
	
	@Override
	public Integer getMenuQty() {
		return qty;
	}
	
	
	
}
