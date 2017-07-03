package com.fsa.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fsa.model.Address;
import com.fsa.model.Restaurant;
import com.fsa.service.contract.RestaurantInfo;
import com.fsa.service.RestaurantService;

public class RestaurantDataHolder {
	/*
	 * I am not happy with this data structure. 
	 * But I am not able to comeup to anythign else
	 * Any suggestion?
	 */
	Map <String,List<Restaurant>> restaurantData = null;
	
	public RestaurantDataHolder (Map<String,List<Restaurant>> restMap) {
		restaurantData = restMap;
	}
	
	public List<RestaurantInfo> getRestaurantsByName (String restName) {
		List<RestaurantInfo> restList = null;
		if(null != restaurantData) {
			 restList = converObject((List<Restaurant>)restaurantData.get(restName));
		} 
		return restList;
	}
	
	public List<RestaurantInfo> getRestaurantByAddress (Address location) {
		List<RestaurantInfo> resultRestList = null;
		
		for ( Entry<String, List<Restaurant>> entry: restaurantData.entrySet() ) {
			List<Restaurant> restList =(List<Restaurant>) entry.getValue();
			for(Restaurant rest: restList) {
				if (rest.getAddress().equals(location)){
					if(null == resultRestList) {
						resultRestList = new ArrayList<RestaurantInfo>();
					}
					resultRestList.add(new RestaurantService(rest));
				}
			}
		} 
		return resultRestList;
	}
	
	public List<RestaurantInfo> getRestaurantByNameAndAddress (String name, Address location) {
		List<RestaurantInfo> resultRestList = null;
			List<Restaurant> restList =(List<Restaurant>) restaurantData.get(name);
			for(Restaurant rest: restList) {
				if (rest.getAddress().equals(location)){
					if(null == resultRestList) {
						resultRestList = new ArrayList<RestaurantInfo>();
					}
					resultRestList.add(new RestaurantService(rest));
				}
			}
		 
		return resultRestList;
	}
	
	public List<RestaurantInfo> converObject (List<Restaurant> restList) {
		List<RestaurantInfo> resultList = null;
		if(null != restList && !restList.isEmpty()) {
			int size = restList.size();
			for(int i=0 ; i<size; i++ ){
				if(null == resultList)
					resultList = new ArrayList<>();
				resultList.add(new RestaurantService(restList.get(i)));
			}
			
		}
		return resultList;
	}
	
	
}
