package com.example.coding.ListStudentsII.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="contactinfo")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min=5, message="La direccion debe contener sobre 5 caracteres")
    @Size(max=50, message="La direccion debe contenter menos de 50 caracteres")
    @NotNull(message="Las direcciones deben tener algo escrito!")
    private String address;
    
    @Size(min=3, message="La ciudad debe contener más de 3 caracteres")
    @Size(max=50, message="La ciudad debe contener menos de 50 caracteres")
    @NotNull(message="Las ciudades deben tener algo escrito!")
    private String city;
    
    @Size(min=1, message="No debes tener un estado con menos de 1 caracter")
    @Size(max=4, message="No debes tener un estado con más de 4 caracteres")
    @NotNull(message="El Estado debe tener algo escrito!")
    private String state;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", unique = true)
    private Student student;
    
    

    /**
     * BEAN CONSTRUCTOR
     * */
	public Contact() {
	}

	/**
	 * TEST CONSTRUCTOR
	 * */
	public Contact(
			@Size(min = 5, message = "La direccion debe contener sobre 5 caracteres") @Size(max = 50, message = "La direccion debe contenter menos de 50 caracteres") String address,
			@Size(min = 3, message = "La ciudad debe contener más de 3 caracteres") @Size(max = 50, message = "La ciudad debe contener menos de 50 caracteres") String city,
			@Size(min = 1, message = "No debes tener un estado con menos de 1 caracter") @Size(max = 4, message = "No debes tener un estado con más de 4 caracteres") String state,
			Student student) {
		this.address = address;
		this.city = city;
		this.state = state;
		this.student = student;
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

	//GETTERS AND SETTERS;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}	
}