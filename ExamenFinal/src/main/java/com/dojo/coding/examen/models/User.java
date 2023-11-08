package com.dojo.coding.examen.models;

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
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="• name field must not be blan")
	@Size(min=2, message="• name must be 2 characters or more")
	@Column(nullable = false)
	private String name;
	
	@NotBlank(message="• Email field must not be blank")
	@Email(message=" • Email is in an invalid format. proper format: name@host.com")
	@Column(nullable = false)
	private String email;
	
	@NotBlank(message="• Password field must not be blank")
	@Size(min=5,message="• Password must be 5 characters or more")
	@Column(nullable = false)
	private String password;

	@NotBlank(message="• Password Confirmation field must not be blank")
	@Transient
	private String passwordConfirmation;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = false)
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = false)
	private Date updatedAt;

	
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Show> createdShows;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Rating> ratings;

    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "ratings",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "show_id")
    )
    private List<Show> Shows;

    
    

	public User(Long id,
			@NotBlank(message = "• name field must not be blan") @Size(min = 2, message = "• name must be 2 characters or more") String name,
			@NotBlank(message = "• Email field must not be blank") @Email(message = " • Email is in an invalid format. proper format: name@host.com") String email,
			@NotBlank(message = "• Password field must not be blank") @Size(min = 5, message = "• Password must be 5 characters or more") String password,
			@NotBlank(message = "• Password Confirmation field must not be blank") String passwordConfirmation,
			Date createdAt, Date updatedAt, List<Show> createdShows, List<Rating> ratings, List<Show> shows) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdShows = createdShows;
		this.ratings = ratings;
		Shows = shows;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(Shows, createdAt, createdShows, email, id, name, password, passwordConfirmation, ratings,
				updatedAt);
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
		return Objects.equals(Shows, other.Shows) && Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(createdShows, other.createdShows) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password)
				&& Objects.equals(passwordConfirmation, other.passwordConfirmation)
				&& Objects.equals(ratings, other.ratings) && Objects.equals(updatedAt, other.updatedAt);
	}

	

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", passwordConfirmation=" + passwordConfirmation + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", createdShows=" + createdShows + ", ratings=" + ratings + ", Shows=" + Shows + "]";
	}



	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Show> getCreatedShows() {
		return createdShows;
	}

	public void setCreatedShows(List<Show> createdShows) {
		this.createdShows = createdShows;
	}

	public List<Show> getShows() {
		return Shows;
	}

	public void setShows(List<Show> shows) {
		Shows = shows;
	}
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	

}
