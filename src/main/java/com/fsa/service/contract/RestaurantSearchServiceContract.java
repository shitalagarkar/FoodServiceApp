package com.fsa.service.contract;

import java.util.List;

public interface RestaurantSearchServiceContract {
	public List<RestaurantInfo> findRestarantByName(String restarantName);
	public List<RestaurantInfo> findRestarantByLocation(String Location);
	public List<RestaurantInfo> findRestarantByNameAndLocation(String Name, String Location);
	
}
