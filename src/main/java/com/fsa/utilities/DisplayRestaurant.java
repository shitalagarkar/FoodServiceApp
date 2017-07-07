package com.fsa.utilities;

import java.util.List;

import com.fsa.service.contract.RestaurantInfo;


public class DisplayRestaurant {

	public boolean displayRestaurantInformation (List<RestaurantInfo> restaurantInfo, RestaurantFilter filter) {
		if(null != restaurantInfo && ! restaurantInfo.isEmpty()) {
			System.out.println("Id\tName\tAddress\tRating");
			int size = restaurantInfo.size();
			for(int i=0 ; i<size; i++ ){
				RestaurantInfo restInfo = (RestaurantInfo) restaurantInfo.get(i);
				StringBuilder builder = new StringBuilder();
				builder.append(restInfo.getId()).append("\t").append(restInfo.getRestarantName()).
					append("\t").append(restInfo.getRestarantAddress()).append("\t").
					append(restInfo.getRestarantRating());
				System.out.println(builder.toString());
				
			}
			return true;
		} else {
			System.out.println("There is no restaurant found for given criteria");
			return false;
		}
		
	}
	
	public void displayMenuForRestaurant(RestaurantInfo selectedRest) {
		if(null != selectedRest ) {
			System.out.println("-----------Menu-----------");
			System.out.println("\tId\tName\t\tPrice");
			int menuSize = selectedRest.getMenu().size();
			for (int j = 0; j < menuSize; j++) {
				System.out.println("\t" + selectedRest.getMenu().get(j));
			}
		}	
	}
	
}
