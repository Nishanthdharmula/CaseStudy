package com.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {
	
	@Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	
		@Id
	    private int id;
	    private String userName;
	    private String firstName;
	    public void setId(int id) {
			this.id = id;
		}

		private String lastName;
	    private String password;
	    private String email;
	    private String roles;
	    private Boolean active;
	    

	    public User() {
	    }

	    public int getId() {
	        return id;
	    }

	    public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
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

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public Boolean getActive() {
	        return active;
	    }

	    public void setActive(Boolean active) {
	        this.active = active;
	    }

	 

	    public String getRoles() {
	        return roles;
	    }

	    public void setRoles(String roles) {
	        this.roles = roles;
	    }

	    @Override
	    public String toString() {
	        return "User [active=" + active + ", email=" + email + ", firstName=" + firstName + ", id=" + id
	                + ", lastName=" + lastName + ", password=" + password + ", roles=" + roles + ", userName=" + userName
	                + "]";
	    }


	}



