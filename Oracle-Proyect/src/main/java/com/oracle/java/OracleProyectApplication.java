package com.oracle.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OracleProyectApplication {

	public static void main(String[] args) {

		double tax = 0.2;

		double total = 0.0;

		System.out.println("Welcome to duke choice shop!");

		Customer c1 = new Customer("Pinky", 14); // Lo llamo de una nueva clase

		// c1.setName("pinky"); //Le coloco lo que es c1

		System.out.println("Customer is " + c1.getName()); // Lo imprimo

		String name = "Pinky";
		String name2 = "asd";
		boolean sameName = name.equals(name2);
		System.out.println(sameName);

		Clothing item1 = new Clothing("blue jacket", 20.9, "M");
		Clothing item2 = new Clothing("Orange-Shirt", 10.5, "S");

		Clothing[] items = { item1, item2, new Clothing("Green scarf", 5.0, "S"),
				new Clothing("Blue t-shirt", 10.5, "S") };

		// System.out.println("item 1" + "," + item1.description + "," + item1.price +
		// "," + item1.size);
		// System.out.println("item 2" + "," + item2.description + "," + item2.price +
		// "," + item2.size);

		// total = ( item1.price + item2.price * 2) * (1 + tax);

		int measurement = 3;

		System.out.println("customer is " + c1.getName() + "," + c1.getSize() + ",");
		for (Clothing item : c1.getItems()) {
			System.out.println("items" + item.getDescription());
		}

		switch (measurement) {
		case 1:
		case 2:
		case 3:
			c1.setSize("S");
			break;
		case 4:
		case 5:
		case 6:
			c1.setSize("M");
			break;
		case 7:
		case 8:
		case 9:
			c1.setSize("L");
			break;
		default:
			c1.setSize("X");

		}

		for (Clothing item : items) {
			if (c1.getSize().equals(item.size)) {
				total = total + item.price;
				System.out.println("itemmmm" + "," + item.description + "," + item.price + "," + item.size);
				if (total > 15) {
					break;
				}
			}
		}
		System.out.println("Total = " + total);

	}

}
