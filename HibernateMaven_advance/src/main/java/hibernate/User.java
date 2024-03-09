package hibernate;

import java.time.Instant;
import java.util.Set;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user", schema = "db_hiberate_advance")
public class User {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fullname")
	private String fullname;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "create_at")
	private Instant createdAt;

	@Column(name = "modified_at")
	private Instant modifiedAt;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private UserProfile userProfile;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@OrderBy("title")
	private Set<Post> posts;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", joinColumns = {
			@JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", nullable = false, updatable = false) })
	@OrderBy("name")
	private Set<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Instant modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@Override
	public String toString() {
		String s = "id: " + id + "\nFullname: " + fullname + "\nUsername: " + username + "\nCreated_at: " + createdAt;
		return s;
	}
}