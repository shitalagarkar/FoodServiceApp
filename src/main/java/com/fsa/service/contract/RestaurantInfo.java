package com.fsa.service.contract;

import java.util.List;


public interface RestaurantInfo {
	public String getRestarantAddress();
	public Double getRestarantRating();
	public List<String> getMenu();
	public List<String> getNonVegMenu();
	public List<String> getVegMenu();
	public String getRestarantName();
	public Integer getId();
	public Double getMenuPrice(Integer menuId);
	public String getMenuName(Integer menuId);
	
}
