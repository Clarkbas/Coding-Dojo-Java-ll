package com.example.coding.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.coding.test.validator") // Asegúrate de ajustar el paquete al lugar donde está la clase UserValidator
public class TestIApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestIApplication.class, args);
	}

}
