package com.example.coding.authentication.models;

import java.time.LocalDateTime;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//imports removidos para resumir.
@Entity
@Table(name="users")
public class User {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;
 @NotBlank(message = "Debe al menos un @")
 @Size(min=9, message="El correo debe tener minimo 9 caracteres")
 private String email;
 @Size(min=5, message="La contraseña debe ser mayor a 5 digitos")
 private String password;
 @Transient
 private String passwordConfirmation;
 @Column(nullable = false)
 @NotBlank
 @Size(min=3, message="Debe tener al menos 3 caracteres")
 private String FirstName;
 @Column(nullable = false)
 private String LastName;

 private boolean superAdmin;
 private static final Long SUPER_ADMIN_ID = 1L; // ID deseado para el superadministrador


private boolean admin;
@Column(updatable=false)
@Temporal(TemporalType.TIMESTAMP)
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date createdAt;
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date updatedAt;
private LocalDateTime registrationDate;
@Temporal(TemporalType.TIMESTAMP)
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date lastSignIn;

public User(Long id, @Size(min = 9, message = "El correo debe tener minimo 9 caracteres") String email,
		@Size(min = 5, message = "La contraseña debe ser mayor a 5 digitos") String password,
		String passwordConfirmation, String firstName, String lastName, boolean superAdmin, Date lastSignIn, boolean admin,
		Date createdAt, Date updatedAt) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
	this.passwordConfirmation = passwordConfirmation;
	FirstName = firstName;
	LastName = lastName;
	this.lastSignIn = lastSignIn;
	this.admin = admin;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.superAdmin = superAdmin;
}



public Date getLastSignIn() {
	return lastSignIn;
}



public void setLastSignIn(Date lastSignIn) {
	this.lastSignIn = lastSignIn;
}



public String getFirstName() {
	return FirstName;
}



public void setFirstName(String firstName) {
	FirstName = firstName;
}



public String getLastName() {
	return LastName;
}



public void setLastName(String lastName) {
	LastName = lastName;
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


 public boolean isAdmin() {
     return admin;
 }

 public void setAdmin(boolean admin) {
     this.admin = admin;
 }



public boolean isSuperAdmin() {
	return superAdmin;
}
public void setSuperAdmin(boolean superAdmin) {
    this.superAdmin = superAdmin;
}
	

 
}

