package com.fsa.service;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.fsa.model.menu.Bill;
import com.fsa.service.contract.BIllPrinter;

public class BillPrinterService implements BIllPrinter {

	Bill billToPrint = null;
	
	
	public BillPrinterService(Bill billToPrint) {
		this.billToPrint = billToPrint;
	}


	@Override
	public void printBill() {
		System.out.println("_----------------- Invoice ----------------- ");
		System.out.println("Restaurant : " + billToPrint.getRestaurantName());
		System.out.println("Address    : " + billToPrint.getRestaurantAddress());
		System.out.println("---------------Item Details---------------");
		int menuSize = billToPrint.getSelectedMenuList().size();
		for (int j = 0; j < menuSize; j++) {
			System.out.println(billToPrint.getSelectedMenuList().get(j));
		}
		System.out.println("Total      : " + billToPrint.getTotalPrice());
	}

}
