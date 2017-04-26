package gr.Accenture2.TradingPlatform.core.entity;

import java.util.Date;
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
 * @author ekiras
 */
/**
 * @author Billy
 *
 */
/**
 * @author Billy
 *
 */
@Entity
@Table(name = "users")
public class User {


    /**
     * The id in database
     */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@Column(name = "firstname", nullable = false)
    private String firstName;
    
	@Column(name = "lastname", nullable = false)
    private String lastName;
    
	@Column(name = "birthdate", columnDefinition = "TIMESTAMP")
    private Date birthDate;
    
	@Column(name = "mobile", nullable = false, length = 15)
    private String mobile;
    
    /**
     * The username
     */
	
	@Column(name = "username", nullable = false)
    private String username;

    /**
     * The password
     */
	@Column(name = "password", nullable = false)
    private String password;

    /**
     * The flag that indicates if the user is enabled
     */
	@Column(name = "enabled", nullable = false)
    private boolean enabled;

	/**
     * The email
     */
	@Column(name = "email", nullable = false)
    private String email;
	

    /**
     * The list of roles the user is assigned to
     */
    @ManyToMany
    @JoinTable(	name = "users_to_roles", 
    			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;

    @Column(name = "cashbalance", nullable = false, columnDefinition = "FLOAT DEFAULT 1000", precision = 10, scale = 2)
    private Float cashBalance;
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Float getCashBalance() {
		return cashBalance;
	}

	public void setCashBalance(Float cashBalance) {
		this.cashBalance = cashBalance;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", username=");
		builder.append(username);
		builder.append(", enabled=");
		builder.append(enabled);
		//builder.append(", roles=");
		//builder.append(roles);
		builder.append("]");
		return builder.toString();
	}

	
	
}