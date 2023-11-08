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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "academies")
public class Academy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAcademy;
    private String name_academy;
    
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
	//===========RELACIONES==========
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "users_academies", 
		joinColumns = @JoinColumn(name = "academy_id"), 
		inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private List<User> users;
    
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="school_id")
    private School school;
	
    //=================================
	public Academy() {
		
	}
	public Long getIdAcademy() {
		return idAcademy;
	}
	public void setIdAcademy(Long idAcademy) {
		this.idAcademy = idAcademy;
	}
	public String getName_academy() {
		return name_academy;
	}
	public void setName_academy(String name_academy) {
		this.name_academy = name_academy;
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
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	

}
