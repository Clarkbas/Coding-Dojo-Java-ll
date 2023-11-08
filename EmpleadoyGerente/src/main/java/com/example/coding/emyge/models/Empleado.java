package com.example.coding.emyge.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Empleados")
public class Empleado {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String firstName;
 private String lastName;
 private Date createdAt;
 private Date updatedAt;
 
 @OneToMany(fetch = FetchType.LAZY)
 @JoinColumn(name = "manager_id")
 private List<Empleado> empleados;
 
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "manager_id")
 private Empleado manager;

public Empleado(Long id, String firstName, String lastName, Date createdAt, Date updatedAt, List<Empleado> empleados,
		Empleado manager) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.empleados = empleados;
	this.manager = manager;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}

public List<Empleado> getEmpleados() {
	return empleados;
}

public void setEmpleados(List<Empleado> empleados) {
	this.empleados = empleados;
}

public Empleado getManager() {
	return manager;
}

public void setManager(Empleado manager) {
	this.manager = manager;
}
 
 
    
}