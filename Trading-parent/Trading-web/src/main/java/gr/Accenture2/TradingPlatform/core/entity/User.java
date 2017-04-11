package gr.Accenture2.TradingPlatform.core.entity;

import java.util.Set;

/**
 * @author ekiras
 */
 
public class User {


    /**
     * The id in database
     */
    private long id;

    
    /**
     * The username
     */
    private String username;

    /**
     * The password
     */
    private String password;

    /**
     * The flag that indicates if the user is enabled
     */
    private boolean enabled;

    /**
     * The list of roles the user is assigned to
     */
    private Set<Role> roles;

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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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
		builder.append(", roles=");
		builder.append(roles);
		builder.append("]");
		return builder.toString();
	}

	
	
}