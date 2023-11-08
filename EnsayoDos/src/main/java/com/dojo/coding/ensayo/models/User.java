package com.dojo.coding.ensayo.models;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="• Nombre field must not be blan")
	@Size(min=2, message="• Nombre must be 2 characters or more")
	private String Nombre;
	
	@NotBlank(message="• Email field must not be blank")
	@Email(message=" • Email is in an invalid format. proper format: name@host.com")
	private String email;
	
	@NotBlank(message="• Password field must not be blank")
	@Size(min=5,message="• Password must be 5 characters or more")
	private String password;
	
	@NotBlank(message="• Password Confirmation field must not be blank")
    @Transient
    private String passwordConfirmation;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Event> events;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Comment> comments;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "joined_events",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="event_id")
			)
	private List<Event>joinedEvents;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	

	
	
	public User(Long id,
			@NotBlank(message = "• First Name field must not be blank") @Size(min = 2, message = "• First name must be 2 characters or more") String nombre,
			@NotBlank(message = "• Email field must not be blank") @Email(message = " • Email is in an invalid format. proper format: name@host.com") String email,
			@NotBlank(message = "• Password field must not be blank") @Size(min = 5, message = "• Password must be 5 characters or more") String password,
			@NotBlank(message = "• Password Confirmation field must not be blank") String passwordConfirmation,
			List<Event> events, List<Comment> comments, List<Event> joinedEvents, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		Nombre = nombre;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.events = events;
		this.comments = comments;
		this.joinedEvents = joinedEvents;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	


	@Override
	public int hashCode() {
		return Objects.hash(Nombre, comments, createdAt, email, events, id, joinedEvents, password,
				passwordConfirmation, updatedAt);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(Nombre, other.Nombre) && Objects.equals(comments, other.comments)
				&& Objects.equals(createdAt, other.createdAt) && Objects.equals(email, other.email)
				&& Objects.equals(events, other.events) && Objects.equals(id, other.id)
				&& Objects.equals(joinedEvents, other.joinedEvents) && Objects.equals(password, other.password)
				&& Objects.equals(passwordConfirmation, other.passwordConfirmation)
				&& Objects.equals(updatedAt, other.updatedAt);
	}


	


	@Override
	public String toString() {
		return "User [id=" + id + ", Nombre=" + Nombre + ", email=" + email + ", password=" + password
				+ ", passwordConfirmation=" + passwordConfirmation + ", events=" + events + ", comments=" + comments
				+ ", joinedEvents=" + joinedEvents + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}




	public User() {
		
	}
	
	
	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Event> getJoinedEvents() {
		return joinedEvents;
	}

	public void setJoinedEvents(List<Event> joinedEvents) {
		this.joinedEvents = joinedEvents;
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

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	
	



}
