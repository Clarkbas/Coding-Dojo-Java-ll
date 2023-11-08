package com.example.coding.authentication.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

//imports removidos para resumir.
@Entity
@Table(name="users")
public class User {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;
 @Size(min=9, message="El correo debe tener minimo 9 caracteres")
 private String email;
 @Size(min=5, message="La contraseña debe ser mayor a 5 digitos")
 private String password;
 @Transient
 private String passwordConfirmation;
 @Column(updatable=false)
 @DateTimeFormat(pattern = "yyyy-MM-dd")
 private Date createdAt;
 @DateTimeFormat(pattern = "yyyy-MM-dd")
 private Date updatedAt;
 
 
 
 public User(Long id, String email, String password, String passwordConfirmation, Date createdAt, Date updatedAt) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
	this.passwordConfirmation = passwordConfirmation;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
}



public User() {
	
 }
 
 

public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}



public String getPasswordConfirmation() {
	return passwordConfirmation;
}



public void setPasswordConfirmation(String passwordConfirmation) {
	this.passwordConfirmation = passwordConfirmation;
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



@PrePersist
 protected void onCreate(){
     this.createdAt = new Date();
 }
 @PreUpdate
 protected void onUpdate(){
     this.updatedAt = new Date();
 }
 
}

