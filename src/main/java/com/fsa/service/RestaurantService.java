package com.fsa.service;

import java.util.ArrayList;
import java.util.List;

import com.fsa.model.Restaurant;
import com.fsa.model.contract.MenuItem;
import com.fsa.service.contract.RestaurantInfo;


public class RestaurantService implements RestaurantInfo{

	Restaurant resta ;
	
	public RestaurantService(Restaurant resta) {
		this.resta = resta;
	}
	
	@Override
	public Integer getId() {
		return resta.getId();
	}

	@Override
	public String getRestarantAddress() {
		StringBuilder builder = new StringBuilder();
		builder.append(resta.getAddress().getStreet1()).append(" ").append(resta.getAddress().getArea());
		return builder.toString();
	}

	@Override
	public Double getRestarantRating() {
		return resta.getRating();
	}

	@Override
	public List<String> getMenu() {
		return createMenuList(resta.getRestMenu().getCompleteMenu());
	}

	@Override
	public List<String> getNonVegMenu() {
		return createMenuList(resta.getRestMenu().getNonVegMenu());
	}

	@Override
	public List<String> getVegMenu() {
		return createMenuList(resta.getRestMenu().getVegMenu());
	}

	@Override
	public String getRestarantName() {
		return resta.getName();
	}

	private List<String> createMenuList(List<MenuItem> lst) {
		List<String> resultList = new ArrayList<>();
		if(null != lst && !lst.isEmpty()){
			int size = lst.size();
			for(int index=0 ; index< size; index++) {
				MenuItem tempMenu = (MenuItem) lst.get(index);
				StringBuilder menu = new StringBuilder();
				menu.append(tempMenu.getMenuId()).append("\t").append(tempMenu.getItemName()).append("\t").
					append(tempMenu.getItemPrice());
				resultList.add(menu.toString());
			}
		}
		return resultList;
	}

	@Override
	public Double getMenuPrice(Integer menuId) {
		MenuItem item = resta.getRestMenu().getMenuItemById(menuId);
		return item.getItemPrice();
	}

	@Override
	public String getMenuName(Integer menuId) {
		MenuItem item = resta.getRestMenu().getMenuItemById(menuId);
		return item.getItemName();
	}
	
	
	
}
