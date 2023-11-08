package com.oracle.java;

public class Customer {

	private String name;
	String name2;
	private String size;

	private Clothing items;

	public Customer(String name, int measurement) {
		this.name = name;
		setSize(measurement);
	}

	private void setSize(int measurement) {
		switch (measurement) {
		case 1:
		case 2:
		case 3:
			size = "S";
			break;
		case 4:
		case 5:
		case 6:
			setSize("M");
			break;
		case 7:
		case 8:
		case 9:
			setSize("L");
			break;
		default:
			setSize("XL");
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String measurement) {
		this.size = measurement;
	}

	public Clothing[] getItems() {
		return null;
	}

}
