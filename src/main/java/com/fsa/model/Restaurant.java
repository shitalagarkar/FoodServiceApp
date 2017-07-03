package com.fsa.model;

import com.fsa.model.contract.MenuList;

public class Restaurant {
	
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
	
	public Address getAddress() {
		return address;
	}
	
	public MenuList getRestMenu() {
		return restMenu;
	}
	
	public Double getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}
	
}
