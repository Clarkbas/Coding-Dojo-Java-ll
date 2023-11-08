package com.oracle.java;

public class Clothing {

	String description;
	double price;
	String size = "M";

	double MIN_PRICE = 10.0;
	double MIN_TAX = 2;

	public Clothing(String description, double price, String aSize) {
		this.description = description;
		this.price = price;
		size = aSize;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
