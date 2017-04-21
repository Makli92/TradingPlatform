package gr.Accenture2.TradingPlatform.core.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


 
/**
 * @author Billy
 * 
 * This class encapsules the role entity for authorization purposes
 *
 */
@Entity
@Table(name = "roles")
public class Role {


    /**
     * The id in database
     */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * The role name
     */
	@Column(name = "role", nullable = false)
    private String role;

    /**
     * The users that the current role is assigned.
     * 
     * Maybe it's not necessary.
     * 
     */
	@ManyToMany(mappedBy = "roles")
    private Set<User> users;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Role [id=");
		builder.append(id);
		builder.append(", role=");
		builder.append(role);
		//builder.append(", users=");
		//builder.append(users);
		builder.append("]");
		return builder.toString();
	}

}