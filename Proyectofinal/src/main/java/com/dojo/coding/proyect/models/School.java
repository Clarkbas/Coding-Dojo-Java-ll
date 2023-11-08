package com.dojo.coding.proyect.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "schools")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSchool;
    private String name_school;

    @Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
	//=============RELACIONES=================
	@OneToMany(mappedBy="school", fetch = FetchType.LAZY)
    private List<User> users;
	 
	@OneToMany(mappedBy="school", fetch = FetchType.LAZY)
    private List<Academy> academies;
    //===========================================
	
	public School() {
		
	}
	public Long getIdSchool() {
		return idSchool;
	}
	public void setIdSchool(Long idSchool) {
		this.idSchool = idSchool;
	}
	public String getName_school() {
		return name_school;
	}
	public void setName_school(String name_school) {
		this.name_school = name_school;
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
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Academy> getAcademies() {
		return academies;
	}
	public void setAcademies(List<Academy> academies) {
		this.academies = academies;
	}
    
    
}
