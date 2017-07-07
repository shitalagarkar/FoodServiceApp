
package com.fsa.main;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import com.fsa.model.BillInputParameters;
import com.fsa.model.contract.SelectedMenuItem;
import com.fsa.model.menu.Bill;
import com.fsa.model.menu.SelectedMenu;
import com.fsa.service.BillGeneratorService;
import com.fsa.service.BillPrinterService;
import com.fsa.service.contract.BIllPrinter;
import com.fsa.service.contract.BillGenerator;
import com.fsa.service.contract.RestaurantInfo;
import com.fsa.utilities.DisplayRestaurant;
import com.fsa.utilities.RestaurantFilter;

public class FoodDeliveryApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 0. Prepare data
		// 1. Find list of Restaurants
		// 2. Select Restaurant
		// 3. Browse through Menu
		// 4. Select Menu
		// 5. Checkout and create Bill
		// 6. Payment
		final String EXIT = "exit";
		Scanner scanInput = new Scanner(System.in);
		ApplicationDataCreator dataCreator = new ApplicationDataCreator();
		RestaurantDataHolder dataHolder = dataCreator.createData();
		List<SelectedMenuItem> selectedMenu = null;
		int qty = 0;
		boolean result = false;
		RestaurantFilter filter = null;
		DisplayRestaurant restDisplay  = null;
		List<RestaurantInfo> restaurantList = null;
		do {
				while (result == false) {
					System.out.println("Enter Search Criteria: ");
					System.out.println("Name: ");
					String restaurantName = scanInput.nextLine();
					checkForExitCondition(EXIT, restaurantName);
					System.out.println("Address: ");
					String restaurantAdd = scanInput.nextLine();
					checkForExitCondition(EXIT, restaurantName);
					filter = new RestaurantFilter(restaurantName, restaurantAdd, dataHolder);
					// doubt: should this stmt be part of display? I think NO as it will break Single Responsibility Principal
					// Please comment.
					restaurantList = filter.findRestaurants();
					restDisplay = new DisplayRestaurant();
					// Passing filter so that incase in future if you require filter information for display
					result = restDisplay.displayRestaurantInformation(restaurantList,filter);
				}	
			result = false;	
			System.out.println("Please select Restaurant Id to display Menu: ");
			int restId =scanInput.nextInt();
			RestaurantInfo selectedRest = filter.filterRestaurantById(restId,restaurantList);
			restDisplay.displayMenuForRestaurant(selectedRest);
			System.out.println("Select Menu using ID and to end selection enter -1");
			int menuId =scanInput.nextInt();
			
			while(menuId != -1){
				System.out.print("Enter Qty: ");
				qty = scanInput.nextInt();
				SelectedMenuItem selectMenu = new SelectedMenu
						(qty,menuId,selectedRest.getMenuPrice(menuId),selectedRest.getMenuName(menuId), null);
				if( null == selectedMenu ) {
					 selectedMenu = new ArrayList<>();
				}
				selectedMenu.add(selectMenu);
				System.out.println("Select Menu using ID and to end selection enter -1");
				menuId =scanInput.nextInt();
			}
			
			// Input param can be taken as generator object variable. 
			// Let's discuss pros n cons of it.
			BillInputParameters bInputParam = new BillInputParameters(selectedRest, selectedMenu);
			BillGenerator billGenerator = new BillGeneratorService(); 
			Bill finalBill = billGenerator.generateBill(bInputParam);
			BIllPrinter billPrinter = new BillPrinterService(finalBill);
			billPrinter.printBill();
			bInputParam = null;
			selectedMenu = null;
			
		} while (true);

	}


	private static void checkForExitCondition(final String EXIT, String inputString) {
		if ( EXIT.equalsIgnoreCase(inputString)) {
			System.out.println("Thank you for using application.");
			System.exit(0);
		}
	}

}
