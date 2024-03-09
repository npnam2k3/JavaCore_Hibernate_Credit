package hibernate;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category", schema = "db_hibernate_advance")
public class Category {
	@Id
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	@OrderBy("title")
	private Set<Post> posts;
}