package com.fsa.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fsa.model.Address;
import com.fsa.model.ItemCategory;
import com.fsa.model.Restaurant;
import com.fsa.model.contract.MenuItem;
import com.fsa.model.menu.Menu;
import com.fsa.model.menu.factory.MenuItemFactory;

public class ApplicationDataCreator {

 public RestaurantDataHolder createData() { 
	 
	 MenuItemFactory menuFactory =  MenuItemFactory.getFactory();
	 List <MenuItem> vegMenu = new ArrayList<>();
	 List <MenuItem> nVegMenu = new ArrayList<>();
	 Map <String, List<Restaurant>> restMap = new HashMap<>();
	 
	 /* Restaurant 1 - Deccan Rendavous
	 Address: Apte Road Deccan
	 Menu
	 1. Chicken Biryani
	 2. Butter Chicken
	 3. Chicken Chilli
	 4. Panner Butter Masala
	 5. Kashmiri Pulao
	 
	 Rating - 4.5*/
	 
	 MenuItem item1 = menuFactory.createMenuItem(ItemCategory.NONVEG, "Chicken Biryani", 350d,01);
	 MenuItem item2 = menuFactory.createMenuItem(ItemCategory.NONVEG, "Butter Chicken", 300d,02);
	 MenuItem item3 = menuFactory.createMenuItem(ItemCategory.NONVEG, "Chicken Chilli", 300d,03);
	 MenuItem item4 = menuFactory.createMenuItem(ItemCategory.VEG, "Paneer Butter Masala", 125d,04);
	 MenuItem item5 = menuFactory.createMenuItem(ItemCategory.VEG, "Kashmiri Pulao", 150d,05);
	 nVegMenu.add(item1);
	 nVegMenu.add(item2);
	 nVegMenu.add(item3);
	 vegMenu.add(item4);
	 vegMenu.add(item5);
	 Map<ItemCategory,List<MenuItem>> menuMap  = new HashMap <>();
	 menuMap.put(ItemCategory.NONVEG, nVegMenu);
	 menuMap.put(ItemCategory.VEG, vegMenu);
	 
	 
	 Restaurant deccan = new Restaurant(1000,
			 new Address ("Apte Road", "Deccan") ,new Menu(menuMap), 4.5d, "Deccan Rendevouse");
	 
	 List<Restaurant> restList = new ArrayList<>();
	 restList.add(deccan);
	 
	 restMap.put("Deccan Rendevouse", restList);
	 
	 /* Restaurant 2 - Copa Cabana
	 Address: Apte Road Deccan
	 Menu
	 1. Nachoes
	 2. Butter Chicken
	 3. Chicken Chilli
	 4. Chicken Gusi
	 5. Neer Dosa
	 4. Veg Bhuna
	 5. Veg Pulao
	 6. Appam
	 Rating - 3*/ 

	 MenuItem item11 = menuFactory.createMenuItem(ItemCategory.NONVEG, "Butter Chicken", 350d,01);
	 MenuItem item21 = menuFactory.createMenuItem(ItemCategory.NONVEG, "Chicken Chilli", 350d,02);
	 MenuItem item31 = menuFactory.createMenuItem(ItemCategory.NONVEG, "Chicken Gusi", 400d,03);
	 MenuItem item41 = menuFactory.createMenuItem(ItemCategory.VEG, "Nachoes", 255d,04);
	 MenuItem item51 = menuFactory.createMenuItem(ItemCategory.VEG, "Neer Dosa", 100d,05);
	 MenuItem item61 = menuFactory.createMenuItem(ItemCategory.VEG, "Appam", 120d,06);
	 MenuItem item71 = menuFactory.createMenuItem(ItemCategory.VEG, "Veg Bhuna", 175d,07);
	 
	 List <MenuItem> vegMenu1 = new ArrayList<>();
	 List <MenuItem> nVegMenu1 = new ArrayList<>();
	 
	 nVegMenu1.add(item11);
	 nVegMenu1.add(item21);
	 nVegMenu1.add(item31);
	 vegMenu1.add(item41);
	 vegMenu1.add(item51);
	 vegMenu1.add(item61);
	 vegMenu1.add(item71);
	 Map<ItemCategory,List<MenuItem>> menuMap1  = new HashMap <>();
	 menuMap1.put(ItemCategory.NONVEG, nVegMenu1);
	 menuMap1.put(ItemCategory.VEG, vegMenu1);
	 
	 
	 Restaurant copa = new Restaurant(1001,
			 new Address ("Vishal Nagar", "Wakad") ,new Menu(menuMap1), 4.0d, "Copa Cabana");

	 List<Restaurant> rest2 = new ArrayList<>();
	 rest2.add(copa);
	 restMap.put("Copa Cabana", rest2);
	 
	

	 /* Restaurant 3 - Shiv Sagar
	 Address: Apte Road Deccan
	 Menu
	 1. Dosa
	 2. Uttapa
	 3. Pav Bhaji
	 4. Panner Butter Masala
	 5. Kashmiri Pulao
	 6. Pizza
	 
	 Rating - 1*/

	 MenuItem item42 = menuFactory.createMenuItem(ItemCategory.VEG, "Dosa", 255d, 01);
	 MenuItem item52 = menuFactory.createMenuItem(ItemCategory.VEG, "Uttapa", 100d,02);
	 MenuItem item62 = menuFactory.createMenuItem(ItemCategory.VEG, "Pav Bhaji", 120d,03);
	 MenuItem item72 = menuFactory.createMenuItem(ItemCategory.VEG, "Pizza", 175d,04);
	 MenuItem item82 = menuFactory.createMenuItem(ItemCategory.VEG, "Tawa Pulao", 175d,05);

	 List <MenuItem> vegMenu2 = new ArrayList<>();
	 	 
	 vegMenu2.add(item42);
	 vegMenu2.add(item52);
	 vegMenu2.add(item62);
	 vegMenu2.add(item72);
	 vegMenu2.add(item82);
	 
	 Map<ItemCategory,List<MenuItem>> menuMap2  = new HashMap <>();
	  menuMap2.put(ItemCategory.VEG, vegMenu2);
	 
	 
	 Restaurant shivSagar = new Restaurant(1002,
			 new Address ("Vishal Nagar", "Wakad") ,new Menu(menuMap2), 1.5d, "Shiv Sagar");

	 Restaurant shivSagar2 = new Restaurant(1003,
			 new Address ("J M Road", "Deccan") ,new Menu(menuMap2), 3.5d, "Shiv Sagar");

	 List<Restaurant> restList3 = new ArrayList<>();
	 restList3.add(shivSagar);
	 restList3.add(shivSagar2);
	 
	 restMap.put("Shiv Sagar", restList3);
	 
	 return new RestaurantDataHolder(restMap);
 }
	
	
}
