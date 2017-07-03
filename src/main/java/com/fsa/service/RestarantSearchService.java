package com.fsa.service;

import java.util.List;

import com.fsa.main.RestaurantDataHolder;
import com.fsa.model.Address;
import com.fsa.model.Restaurant;
import com.fsa.service.contract.RestaurantInfo;
import com.fsa.service.contract.RestaurantSearchServiceContract;
/*
 * I think this class should not return Restaurant objects directly. 
 * Instead it should return RestaurantService objects.
 * feel so as returning Restaurant objects, we directly give access to Restaurant objects
 * What are your views on this?
 * 
 */

public class RestarantSearchService implements RestaurantSearchServiceContract{
	RestaurantDataHolder holder = null;
	
	 public RestarantSearchService(RestaurantDataHolder restHolder) {
		holder = restHolder;
	}
	
	@Override
	public List<RestaurantInfo> findRestarantByName(String restarantName) {
		return 	holder.getRestaurantsByName(restarantName);	
	}

	@Override
	public List<RestaurantInfo> findRestarantByLocation(String area) {
		Address add = new Address(null, area);
		return holder.getRestaurantByAddress(add);
	}

	@Override
	public List<RestaurantInfo> findRestarantByNameAndLocation(String name, String location) {
		Address add = new Address(null, location);
		return holder.getRestaurantByNameAndAddress(name, add);
	}

}
