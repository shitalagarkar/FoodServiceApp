package com.fsa.utilities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fsa.main.RestaurantDataHolder;
import com.fsa.service.RestarantSearchService;
import com.fsa.service.contract.RestaurantInfo;
import com.fsa.service.contract.RestaurantSearchServiceContract;


public class RestaurantFinder {
	
	
	RestaurantFIlter restFilter; 
	List<RestaurantInfo> restaurantList = null;
	RestaurantDataHolder holder; 
	
	public RestaurantFinder(RestaurantFIlter filter, RestaurantDataHolder holder) {
		restFilter = filter;
		this.holder = holder;
	}
	
	public List<RestaurantInfo> findRestaurants () {
		Set <RestaurantInfo> uniqueRestaurantSet = null;
		uniqueRestaurantSet = new HashSet <> ();
		String name =  restFilter.getName();
		String address = restFilter.getAddress();
		//--------------------------------------------------------------
		RestaurantSearchServiceContract searchService = new RestarantSearchService(holder);
		
		boolean nameExists = (null != name&& !name.isEmpty() && ! name.equalsIgnoreCase("NA")) ? true:false;
		boolean addressExists = (null != address && !address.isEmpty() && ! address.equalsIgnoreCase("NA")) ? true:false;
		
		//--------------------------------------------------------------		
		System.out.println("");
		if (nameExists && addressExists ) {
			List<RestaurantInfo> tempList = searchService.findRestarantByNameAndLocation(name, address);
			if(null != tempList)
				uniqueRestaurantSet.addAll(tempList) ;
		}
		
		if(nameExists){
			List<RestaurantInfo> tempList = searchService.findRestarantByName(name);
			if(null != tempList)
				uniqueRestaurantSet.addAll(tempList) ;
		}

		if (addressExists) {
			List<RestaurantInfo> tempList = searchService.findRestarantByLocation (address);
			if(null != tempList)
				uniqueRestaurantSet.addAll(tempList);
		}
		
		restaurantList = new ArrayList<> ();
		restaurantList.addAll(uniqueRestaurantSet);
		return restaurantList ;
		
	}
	
	public RestaurantInfo filterRestaurantById(Integer id) {
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
