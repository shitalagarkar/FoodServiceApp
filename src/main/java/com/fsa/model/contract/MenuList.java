package com.fsa.model.contract;

import java.util.List;

// Is returning MenuItem a good idea? 
// I am doubtful about it.

public interface MenuList {

	public List<MenuItem> getCompleteMenu ();
	public List<MenuItem> getNonVegMenu();
	public List<MenuItem> getVegMenu();
	public MenuItem getMenuItemById(Integer id);
	
}
