package com.webshop.webapp.enumeration;

public enum DeliveryTypes {

	TWODAYSHIPPING("Two-day shipping"),
	FREEPICKUP("Free pickup");
	
	private String deliveryTypeName;
	
	DeliveryTypes(String deliveryTypeName){
		this.deliveryTypeName = deliveryTypeName;
	}
	
	public String deliveryTypeName(){
		return deliveryTypeName;
	}
	
}
