package gr.Accenture2.TradingPlatform.core.entity;

import java.util.Set;

 
public class Role {


    private long id;

    private String role;

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
		builder.append(", users=");
		builder.append(users);
		builder.append("]");
		return builder.toString();
	}

}