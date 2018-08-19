package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity 
@Table(name="LoginAnnotation")

public class LoginAnnotation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqname2")
	@SequenceGenerator(initialValue = 1, sequenceName = "seqname2", allocationSize = 1, name = "seqname2")
	@Column(name="LOGIN_ID", nullable = false, precision = 10)
	private int loginid;
	
	@Column(name="username", length = 40)	
	private String username;
	
	@Column(name="password", length = 40)
	private String password;

	public int getLoginid() {
		return loginid;
	}

	public void setLoginid(int loginid) {
		this.loginid = loginid;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + loginid;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginAnnotation other = (LoginAnnotation) obj;
		if (loginid != other.loginid)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoginAnnotation [loginid=" + loginid + ", username=" + username + ", password=" + password + "]";
	}

	public LoginAnnotation(int loginid, String username, String password) {
		super();
		this.loginid = loginid;
		this.username = username;
		this.password = password;
	}

	public LoginAnnotation() {
		super();
	}

	

	
	
}
