package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bookings")
public class Bookings extends BaseEntity {

	@ManyToOne()
	@JoinColumn(name = "user_Id")
	private Users user;
	@ManyToOne
	@JoinColumn(name = "package_id")
	private Packages package1;

	private String paytype;

	private String amountPaid;

	private String startdate;

	private String enddate;

	public Bookings() {
		super();
	}

	public Bookings(Users user, Packages package1, String paytype, String amountPaid, String startdate, String enddate) {
		super();
		this.user = user;
		this.package1 = package1;
		this.paytype = paytype;
		this.amountPaid = amountPaid;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Packages getPackage1() {
		return package1;
	}

	public void setPackage1(Packages package1) {
		this.package1 = package1;
	}

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public String getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	@Override
	public String toString() {
		return "Bookings [user=" + user + ", package1=" + package1 + ", paytype=" + paytype + ", amountPaid="
				+ amountPaid + ", startdate=" + startdate + ", enddate=" + enddate + "]";
	}

}
