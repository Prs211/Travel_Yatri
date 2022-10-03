package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contactus")
public class ContactUs extends BaseEntity {

	private String name;
	private String email;
	private String mobile;
	private String comment;
	public ContactUs() {
		super();
	}
	public ContactUs(String name, String email, String mobile, String comment) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.comment = comment;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "ContactUs [name=" + name + ", email=" + email + ", mobile=" + mobile + ", comment=" + comment + "]";
	}
	
	
}
