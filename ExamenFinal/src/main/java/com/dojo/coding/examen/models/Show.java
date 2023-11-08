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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "shows")
public class Show {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    @NotBlank(message = "required")
	    private String name;
	    
	    @Column(nullable = false)
	    @NotBlank(message = "required")
	    private String network;

	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    @Column(nullable = false)
	    private Date createdAt;

	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    @Column(nullable = false)
	    private Date updatedAt;
	    
	    
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "ratings", 
	        joinColumns = @JoinColumn(name = "show_id"), 
	        inverseJoinColumns = @JoinColumn(name = "user_id"))
	    private List<User> usersJoin;
	    
	    @OneToMany(mappedBy = "show", fetch = FetchType.LAZY)
	    private List<Rating> ratings;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    private User user;

		private String red;
	    
		
		

		public Show(Long id, @NotBlank(message = "required") String name,
				@NotBlank(message = "required") String network, Date createdAt, Date updatedAt, List<User> usersJoin,
				List<Rating> ratings, User user, String red) {
			super();
			this.id = id;
			this.name = name;
			this.network = network;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.usersJoin = usersJoin;
			this.ratings = ratings;
			this.user = user;
			this.red = red;
		}
		
		

		@Override
		public int hashCode() {
			return Objects.hash(createdAt, id, name, network, ratings, red, updatedAt, user, usersJoin);
		}



		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Show other = (Show) obj;
			return Objects.equals(createdAt, other.createdAt) && Objects.equals(id, other.id)
					&& Objects.equals(name, other.name) && Objects.equals(network, other.network)
					&& Objects.equals(ratings, other.ratings) && Objects.equals(red, other.red)
					&& Objects.equals(updatedAt, other.updatedAt) && Objects.equals(user, other.user)
					&& Objects.equals(usersJoin, other.usersJoin);
		}

		

		@Override
		public String toString() {
			return "Show [id=" + id + ", name=" + name + ", network=" + network + ", createdAt=" + createdAt
					+ ", updatedAt=" + updatedAt + ", usersJoin=" + usersJoin + ", ratings=" + ratings + ", user="
					+ user + ", red=" + red + "]";
		}



		public Show() {
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

		public String getNetwork() {
			return network;
		}

		public void setNetwork(String red) {
			this.network = red;
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



		public List<User> getUsersJoin() {
			return usersJoin;
		}

		public void setUsersJoin(List<User> usersJoin) {
			this.usersJoin = usersJoin;
		}

		public List<Rating> getRatings() {
			return ratings;
		}

		public void setRatings(List<Rating> ratings) {
			this.ratings = ratings;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public String getRed() {
		    return red;
		}

	    public void setRed(String red) {
	        this.red = red;
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
