package com.fsa.model;

import java.util.List;

import com.fsa.model.contract.MenuItem;
import com.fsa.model.contract.MenuList;

/*
 * In this class, I have written all the possible required methods for Address/Menu assuming we should not give inner object access to anyone.
 * But i think RestaurantInfo class is the interface to outer world, but we should be able to give restaurant inner object access to this class.
 * What you say??
 */

public class Restaurant {
	
	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", address=" + address + ", restMenu=" + restMenu + ", rating=" + rating
				+ ", name=" + name + "]";
	}

	Integer id;
	Address address;

	MenuList restMenu;
	Double rating;
	String name;
	
	public Restaurant(Integer id, Address address, MenuList restMenu, Double rating, String name) {
		this.address = address;
		this.restMenu = restMenu;
		this.rating = rating;
		this.name = name;
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public String getAddress() {
		return address.toString();
	}
	
	public Address getAddressObject() {
		return new Address(address);
	}

	public List<MenuItem> getCompleteMenuList() {
		return restMenu.getCompleteMenu();
	}
	
	public List<MenuItem> getNonVegMenu() {
		return restMenu.getNonVegMenu();
	}

	
	public List<MenuItem> getVegMenu() {
		return restMenu.getVegMenu();
	}

	
	/*public MenuList getRestMenu() {
		return restMenu;
	}*/
	
	public Double getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}
	
	public Double getMenuPrice(Integer menuId) {
		MenuItem item = restMenu.getMenuItemById(menuId);
		return item.getItemPrice();
	}
	
	public String getMenuName(Integer menuId) {
		MenuItem item = restMenu.getMenuItemById(menuId);
		return item.getItemName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Restaurant other = (Restaurant) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
