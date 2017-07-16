package com.fsa.service;

import java.util.ArrayList;
import java.util.List;

import com.fsa.model.Restaurant;
import com.fsa.model.contract.MenuItem;
import com.fsa.service.contract.RestaurantInfo;
import com.fsa.utilities.RestaurantMenuDisplayUtility;


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
		return resta.getAddress();
	}

	@Override
	public Double getRestarantRating() {
		return resta.getRating();
	}

	@Override
	public String getMenu() {
		return new RestaurantMenuDisplayUtility(resta.getCompleteMenuList()).displayRestaurantMenuInformation();
	}

	@Override
	public String getNonVegMenu() {
		return new RestaurantMenuDisplayUtility(resta.getNonVegMenu()).displayRestaurantMenuInformation();
	}

	@Override
	public String getVegMenu() {
		return new RestaurantMenuDisplayUtility(resta.getVegMenu()).displayRestaurantMenuInformation();
	}

	@Override
	public String getRestarantName() {
		return resta.getName();
	}


	@Override
	public Double getMenuPrice(Integer menuId) {
		return  resta.getMenuPrice(menuId);

	}

	@Override
	public String getMenuName(Integer menuId) {
		return resta.getMenuName(menuId);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((resta == null) ? 0 : resta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RestaurantService other = (RestaurantService) obj;
		if (resta == null) {
			if (other.resta != null)
				return false;
		} else if (!resta.equals(other.resta))
			return false;
		return true;
	}
	
	
	
	
}
