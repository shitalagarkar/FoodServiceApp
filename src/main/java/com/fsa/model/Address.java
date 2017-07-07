package com.fsa.model;

public class Address {
	
	String street1;
	String area;
	
	public Address(String street1, String area) {
		super();
		this.street1 = street1;
		this.area = area;
	}

	public String getStreet1() {
		return street1;
	}
	
	public String getArea() {
		return area;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(null != obj &&  (obj instanceof Address )  ){
			Address temp = (Address)obj;
			if(area.equals(temp.area)) {
				return true ;
			} else {
				return false;
			}	
		}
		
		return true;
	}
	
}
