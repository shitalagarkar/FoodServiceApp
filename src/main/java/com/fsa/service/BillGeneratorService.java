package com.fsa.service;

import java.util.List;

import com.fsa.model.BillInputParameters;
import com.fsa.model.contract.SelectedMenuItem;
import com.fsa.model.menu.Bill;
import com.fsa.service.contract.BillGenerator;
import com.fsa.service.contract.RestaurantInfo;

public class BillGeneratorService implements BillGenerator {
	
	
	@Override
	public Bill generateBill(BillInputParameters billParam) {
		Double totalAmt = 0.0d;
		Bill finalBill = null;
		List<SelectedMenuItem>selectedItems = billParam.getSelectedMenu();
		if (null != selectedItems && ! selectedItems.isEmpty()) {
			int size = selectedItems.size();
			for(int index=0; index<size; index++) {
				SelectedMenuItem item = selectedItems.get(index);
				totalAmt = totalAmt+ (item.getItemPrice() * item.getMenuQty());
			}
		}
		
		finalBill = new Bill(billParam.getRestInfo().getRestarantName(),
				billParam.getRestInfo().getRestarantAddress(),billParam.getSelectedMenu(),totalAmt);
		return finalBill;
	}

	/*@Override
	public void printBill() {
		// TODO Auto-generated method stub

	}*/

	@Override
	public Double getTotalBillAmount() {
		// TODO Auto-generated method stub
		return null;
	}

}
