package com.fsa.model.menu;

import java.util.ArrayList;
import java.util.List;

import com.fsa.model.contract.SelectedMenuItem;

public class Bill {
	String restaurantName;
	String restaurantAddress;
	
	List<SelectedMenuItem> selectedMenuList;
	Double totalPrice ;
	
	public Bill(String restaurantName, String restaurantAddress, List<SelectedMenuItem> selectedMenuList, Double totalPrice) {
		super();
		this.restaurantName = restaurantName;
		this.restaurantAddress = restaurantAddress;
		this.selectedMenuList = selectedMenuList;
		this.totalPrice = totalPrice;
	}

	public String getRestaurantName() {
		return restaurantName;
	}
	
	public String getRestaurantAddress() {
		return restaurantAddress;
	}

	/*
	 * Again a doubt this method should return the list of selectedMenuLists or a
	 * list of strings of selected menu information?
	 *  
	 */
	public List<String> getSelectedMenuList() {
		List<String> selectedMenu = null;
		if (null != selectedMenuList && !selectedMenuList.isEmpty()) {
			int size = selectedMenuList.size();
			selectedMenu = new ArrayList<String>();
			StringBuilder builder = new StringBuilder();
			builder.append("Menu\t\t").append("Price\t\t").append("Qty\t\t").append("Total");
			selectedMenu.add(builder.toString());

			for(int i=0; i<size; i++) {
				SelectedMenuItem sMI = selectedMenuList.get(i);
				StringBuilder tempBuilder  = new StringBuilder();
				tempBuilder.append(sMI.getItemName()).append("\t\t").append(sMI.getItemPrice()).
				append("\t\t").append(sMI.getMenuQty()).append("\t\t").append(sMI.getItemPrice() *sMI.getMenuQty() );
				selectedMenu.add(tempBuilder.toString());
			}
		}
		return selectedMenu;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}
	
	
	
}
