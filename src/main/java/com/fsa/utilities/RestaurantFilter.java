package com.fsa.utilities;

import java.util.List;

import com.fsa.main.RestaurantDataHolder;
import com.fsa.service.RestarantSearchService;
import com.fsa.service.contract.RestaurantInfo;
import com.fsa.service.contract.RestaurantSearchServiceContract;


public class RestaurantFilter {
	
	String name;
	String address;
	RestaurantDataHolder holder; 
	
	public RestaurantFilter(String name, String address, RestaurantDataHolder holder) {
		this.name = name;
		this.address = address;
		this.holder = holder;
	}
	
	public List<RestaurantInfo> findRestaurants () {
		List<RestaurantInfo> restaurantList = null;
		/*
		 * NEED TO THINK ABOUT SOME BETTER LOGIC HERE. MAY BE USE OF BIT OPERATIONS??
		 * ANY SUGGESTIONS HERE?
		 */
		//--------------------------------------------------------------
		RestaurantSearchServiceContract searchService = new RestarantSearchService(holder);
		boolean bothAddAndName = ( (null != name && !name.isEmpty() && ! name.equalsIgnoreCase("NA")) 
				&& (null != address && !address.isEmpty() && ! address.equalsIgnoreCase("NA") )) ? true:false; 
		boolean onlyName = bothAddAndName? false: ( ((null != name && !name.isEmpty() && ! name.equalsIgnoreCase("NA")) &&
				(null != address && !address.isEmpty() && address.equalsIgnoreCase("NA") ) ) ) ? true : false ;
				
		boolean onlyAdd = bothAddAndName? false : (((null != address && !address.isEmpty() && !address.equalsIgnoreCase("NA") ) &&  
				(null != name && !name.isEmpty() && name.equalsIgnoreCase("NA"))  ))? true:false;
		//--------------------------------------------------------------		
		
		if(onlyName){
			restaurantList = searchService.findRestarantByName(name);
		}

		if (onlyAdd) {
			restaurantList = searchService.findRestarantByLocation (address);
		}
		
		if(bothAddAndName){
			restaurantList = searchService.findRestarantByNameAndLocation(name, address);
		}
		
		return restaurantList;
		
	}
	
	public RestaurantInfo filterRestaurantById(Integer id, List<RestaurantInfo> restaurantList) {
		RestaurantInfo restInfo = null;

		if (null != restaurantList && !restaurantList.isEmpty()) {
			int size = restaurantList.size();
			for (int i = 0; i < size; i++) {
				restInfo = (RestaurantInfo) restaurantList.get(i);
				if (id.equals(restInfo.getId())) {
					break;
				} else {
					restInfo = null;
				}

			}
		}
		return restInfo;
	}
	
}
