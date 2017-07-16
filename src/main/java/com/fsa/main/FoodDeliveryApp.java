
package com.fsa.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.fsa.formatter.FormatCreatorTypes;
import com.fsa.formatter.FormatterTypes;
import com.fsa.model.BillInputParameters;
import com.fsa.model.contract.SelectedMenuItem;
import com.fsa.model.menu.Bill;
import com.fsa.model.menu.SelectedMenu;
import com.fsa.service.BillGeneratorService;
import com.fsa.service.BillPrinterService;
import com.fsa.service.contract.BIllPrinter;
import com.fsa.service.contract.BillGenerator;
import com.fsa.service.contract.RestaurantInfo;
import com.fsa.utilities.FoodAppConstant;
import com.fsa.utilities.RestaurantDisplayUtility;
import com.fsa.utilities.RestaurantFIlter;
import com.fsa.utilities.RestaurantFinder;

public class FoodDeliveryApp {

	public static void main(String[] args) {
		// 0. Prepare data
		// 1. Find list of Restaurants
		// 2. Select Restaurant
		// 3. Browse through Menu
		// 4. Select Menu
		// 5. Checkout and create Bill
		// 6. Payment

		Scanner scanInput = new Scanner(System.in);
		RestaurantDataHolder dataHolder = createApplicationData();
		List<SelectedMenuItem> selectedMenu = null;
		boolean result = true;
		RestaurantFinder restFinder = null;
		RestaurantDisplayUtility dispUtility = new RestaurantDisplayUtility(FormatCreatorTypes.TAB_CHAR,FormatterTypes.TWOTAB_UPPER);
		Integer restId = null;
		boolean response = true;
		try {
			do {
				while (result == true) {
					restFinder = findRestaurantForSelectedCriteria(scanInput, dataHolder, dispUtility);
					result = askDoYouWantToContinue(scanInput);
				}
				result = false;
				if (null != restFinder) {
					RestaurantInfo selectedRest = displayMenuForSelectedRestaurant(scanInput, restFinder,dispUtility, restId);
					selectedMenu = selectMenuForOrder(scanInput, selectedRest);
					if(null != selectedMenu){
						generateAndPrintBIll(selectedMenu, selectedRest);
					}
				}
				response = askDoYouWantToContinue(scanInput);
			} while (response);
		} finally {
			scanInput.close();
		}
	}

	private static boolean askDoYouWantToContinue(Scanner scanInput) {
		boolean result = false;
		System.out.println("Do you want to search more restaurants?(Yes/No) : ");
		String input = scanInput.nextLine();
		if(FoodAppConstant.YES.equalsIgnoreCase(input)) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	private static RestaurantFinder findRestaurantForSelectedCriteria(Scanner scanInput,
			RestaurantDataHolder dataHolder, RestaurantDisplayUtility dispUtility) {
		RestaurantFinder restFinder;
		List<RestaurantInfo> restaurantList;
		RestaurantFIlter restFilter = captureRestaurantFilter(scanInput);
		restFinder = new RestaurantFinder(restFilter, dataHolder);
		restaurantList = restFinder.findRestaurants();
		dispUtility.displayRestaurantInformation(restaurantList);
		return restFinder;
	}

	private static void generateAndPrintBIll(List<SelectedMenuItem> selectedMenu, RestaurantInfo selectedRest) {
		BillInputParameters bInputParam = new BillInputParameters(selectedRest, selectedMenu);
		BillGenerator billGenerator = new BillGeneratorService();
		Bill finalBill = billGenerator.generateBill(bInputParam);
		BIllPrinter billPrinter = new BillPrinterService(finalBill);
		billPrinter.printBill();
	}

	private static List<SelectedMenuItem> selectMenuForOrder(Scanner scanInput, 
			RestaurantInfo selectedRest) {
		List<SelectedMenuItem> selectedMenu = null;
		int qty;
		System.out.println("Select Menu using ID and to end selection enter -1");
		int menuId = scanInput.nextInt();

		while (menuId != -1) {
			System.out.print("Enter Qty: ");
			qty = scanInput.nextInt();
			SelectedMenuItem selectMenu = new SelectedMenu(qty, menuId, selectedRest.getMenuPrice(menuId),
					selectedRest.getMenuName(menuId), null);
			if (null == selectedMenu) {
				selectedMenu = new ArrayList<>();
			}
			selectedMenu.add(selectMenu);
			System.out.println("Select Menu using ID and to end selection enter -1");
			menuId = scanInput.nextInt();
		}
		return selectedMenu;
	}

	private static RestaurantInfo displayMenuForSelectedRestaurant(Scanner scanInput, RestaurantFinder restFinder, RestaurantDisplayUtility dispUtility, Integer restId) {
		String restIdString;
		System.out.println("Please select Restaurant Id to display Menu or type exit to exit application");
		 restIdString = scanInput.nextLine();
		 System.out.println("restIdString" + restIdString);
		checkForExitCondition(FoodAppConstant.EXIT, restIdString);
		
		try {
			restId = Integer.parseInt(restIdString);
		}catch(NumberFormatException e) {
			System.out.println("Error convering string to number: " + restId);
		}
		
		RestaurantInfo selectedRest = restFinder.filterRestaurantById(restId);
		dispUtility.displayRestaurantMenuInformation(selectedRest);
		return selectedRest;
	}

	private static RestaurantDataHolder createApplicationData() {
		ApplicationDataCreator dataCreator = new ApplicationDataCreator();
		RestaurantDataHolder dataHolder = dataCreator.createData();
		return dataHolder;
	}

	private static RestaurantFIlter captureRestaurantFilter(Scanner scanInput) {
		System.out.println("Enter Search Criteria: ");
		System.out.println("Name: ");
		String restaurantName = scanInput.nextLine();
		checkForExitCondition(FoodAppConstant.EXIT, restaurantName);
		System.out.println("Address: ");
		String restaurantAdd = scanInput.nextLine();
		checkForExitCondition(FoodAppConstant.EXIT, restaurantName);
		RestaurantFIlter filter = new RestaurantFIlter(restaurantName, restaurantAdd);

		return filter;
	}

	private static void checkForExitCondition(final String EXIT, String inputString) {
		if (EXIT.equalsIgnoreCase(inputString)) {
			System.out.println("Thank you for using application.");
			System.exit(0);
		}
	}
}
