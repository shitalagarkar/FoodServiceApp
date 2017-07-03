package com.fsa.service.contract;

import java.util.List;

import com.fsa.model.BillInputParameters;
import com.fsa.model.contract.SelectedMenuItem;
import com.fsa.model.menu.Bill;

public interface BillGenerator {
	public Bill generateBill(BillInputParameters billParam);
//	public void printBill();
	public Double getTotalBillAmount();
}
