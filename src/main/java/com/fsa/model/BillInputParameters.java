package com.fsa.model;

import java.util.List;

import com.fsa.model.contract.SelectedMenuItem;
import com.fsa.service.contract.RestaurantInfo;

public class BillInputParameters {
	RestaurantInfo restInfo;
	List<SelectedMenuItem> selectedMenu;
	
	public BillInputParameters(RestaurantInfo restInfo, List<SelectedMenuItem> selectedMenu) {
		super();
		this.restInfo = restInfo;
		this.selectedMenu = selectedMenu;
	}

	public RestaurantInfo getRestInfo() {
		return restInfo;
	}

	public List<SelectedMenuItem> getSelectedMenu() {
		return selectedMenu;
	}
	
	
}
