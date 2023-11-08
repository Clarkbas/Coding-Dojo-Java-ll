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
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubject;
    private String title_subject;

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
	
	//===============RELACIONES======================
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "califications", 
		joinColumns = @JoinColumn(name = "subject_id"), 
		inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private List<User> users;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "attendances", 
		joinColumns = @JoinColumn(name = "subject_id"), 
		inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private List<User> userAttendance;

    //=============================================
    
	public Subject() {
	}
	public Long getIdSubject() {
		return idSubject;
	}
	public void setIdSubject(Long idSubject) {
		this.idSubject = idSubject;
	}
	public String getTitle_subject() {
		return title_subject;
	}
	public void setTitle_subject(String title_subject) {
		this.title_subject = title_subject;
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
	public List<User> getUserAttendance() {
		return userAttendance;
	}
	public void setUserAttendance(List<User> userAttendance) {
		this.userAttendance = userAttendance;
	}
	
	   	
}
