package com.example.coding.ListStudentsII.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min=2, message="El nombre debe tener más de 3 caracteres")
    @Size(max=50, message="El nombre no debe contener más de 50 caracteres")
    private String firstName;
    
    @Size(min=2, message="El Apellido debe tener más de 3 caracteres")
    @Size(max=50, message="El Apellido no debe contener más de 50 caracteres")
    private String lastName;
    
    @Min(value=16, message="El minimo de la edad debe ser de 16")
    @Max(value=99, message="El maximo de la edad debe ser de 99")
    private Integer age;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Contact contact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dormitory_id")
    private Dormitory dormitory;
    
    
    
    
    /**
     * Declarate first constructor 
     * */
    public Student() {
    }
    /**
     * Declarate TEST constructor 
     * */
	public Student(
			@Size(min = 4, message = "El nombre debe tener más de 3 caracteres") @Size(max = 50, message = "El nombre no debe contener más de 50 caracteres") String firstName,
			@Size(min = 4, message = "El Apellido debe tener más de 3 caracteres") @Size(max = 50, message = "El Apellido no debe contener más de 50 caracteres") String lastName,
			@Min(value = 16, message = "El minimo de la edad debe ser de 16") @Max(value = 99, message = "El maximo de la edad debe ser de 99") Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	/**
	 * DATE GENERATOR
	 * */
	
	@PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

	@PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
	
	/**
	 * Getters && Setters
	 * */
	
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
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
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public Dormitory getDormitory() {
		return dormitory;
	}
	public void setDormitory(Dormitory dormitory) {
		this.dormitory = dormitory;
	}
	
    
}
