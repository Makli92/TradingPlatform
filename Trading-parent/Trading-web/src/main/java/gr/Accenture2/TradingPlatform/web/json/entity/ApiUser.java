package gr.Accenture2.TradingPlatform.web.json.entity;

import gr.Accenture2.TradingPlatform.core.entity.Role;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class ApiUser {

	    private String firstName;
	    
	    private String lastName;
	   
	    private Date birthDate;
	    
	    private String mobile;
	    
	    private String username;

	    private String email;

	    private Float cashBalance;

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

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Float getCashBalance() {
			return cashBalance;
		}

		public void setCashBalance(Float cashBalance) {
			this.cashBalance = cashBalance;
		}
	    
}
