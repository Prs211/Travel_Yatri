package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users extends BaseEntity {

	private String name;
	private String email;
	private String mobile;
	private String password;
	private String status;

	public Users() {
		super();
	}

	public Users(String name, String email, String mobile, String password, String status) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Users [name=" + name + ", email=" + email + ", mobile=" + mobile + ", password=" + password
				+ ", status=" + status + "]";
	}

}
