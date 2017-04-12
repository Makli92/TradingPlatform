package gr.Accenture2.TradingPlatform.web.post.request;

public class RegistrationForm {
	
	private String firstname;
	private String lastname;
	private String birthDate;
	private String mobile;
	private String username;
	private String password;
	private String passwordConfirm;
	private String email;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Registration [firstname=" + firstname + ", lastname="
				+ lastname + ", birthDate=" + birthDate + ", mobile=" + mobile
				+ ", username=" + username + ", password= [hidden]"
				+ ", passwordConfirm=" + passwordConfirm + ", email=" + email
				+ "]";
	}
	
	

}
