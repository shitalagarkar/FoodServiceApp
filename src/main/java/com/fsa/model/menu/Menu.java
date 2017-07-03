package com.fsa.model.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fsa.model.ItemCategory;
import com.fsa.model.contract.MenuItem;
import com.fsa.model.contract.MenuList;

public class Menu implements MenuList {
	private Map<ItemCategory, List<MenuItem>> menuMap;
	
	public Menu(Map<ItemCategory, List<MenuItem>> menuMap) {
		this.menuMap = menuMap;
	}

	public List<MenuItem> getCompleteMenu() {
		List<MenuItem> completeMenuList  = new ArrayList<>(); 
		if(null != menuMap.get(ItemCategory.NONVEG) ){
			completeMenuList.addAll(menuMap.get(ItemCategory.NONVEG)) ;
		}
		if(null != menuMap.get(ItemCategory.VEG)) {
			completeMenuList.addAll(menuMap.get(ItemCategory.VEG));
		}
		 return completeMenuList;
	}

	public List<MenuItem> getNonVegMenu() {
		return menuMap.get(ItemCategory.NONVEG);
	}

	public List<MenuItem> getVegMenu() {
		return menuMap.get(ItemCategory.VEG);
	}

	@Override
	public MenuItem getMenuItemById(Integer id) {
		MenuItem resultMenu = null;
		List<MenuItem> completeMenuList = getCompleteMenu();
		if(null != completeMenuList && !completeMenuList.isEmpty()) {
			int size = completeMenuList.size();
			for (int i=0 ; i< size; i++) {
				MenuItem item = completeMenuList.get(i);
				if (item.getMenuId().equals(id)) {
					resultMenu=item;
					break;
				}
			}
		}
		
		
		return resultMenu;
	}

}
