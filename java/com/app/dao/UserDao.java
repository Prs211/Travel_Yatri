package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Bookings;
import com.app.pojos.ContactUs;
import com.app.pojos.Feedback;
import com.app.pojos.Packages;
import com.app.pojos.Payment;
import com.app.pojos.Users;

@Repository
public class UserDao implements UserDaoInterface {

	@Autowired
	private EntityManager mgr;

	@Override
	public List<Bookings> fetchmyBookings(Users user) {
		try {
			String jpql = "select b from Bookings b where b.user=:user";
			List<Bookings> list = mgr.createQuery(jpql, Bookings.class).setParameter("user", user).getResultList();
			if (list != null)
				return list;
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public Packages fetchPackageByID(int pid) {

		return mgr.find(Packages.class, pid);
	}

	@Override
	public String bookticket(Bookings book) {
		mgr.persist(book);
		return "Booking Confirmed Cash Will be collected on date " + book.getStartdate();
	}

	@Override
	public String bookticket(Users user, Packages pac, String ptype, String discount, String sdate, String edate) {
		Bookings b = new Bookings();
		b.setAmountPaid(discount);
		b.setEnddate(edate);
		b.setStartdate(sdate);
		b.setPackage1(pac);
		b.setPaytype(ptype);
		b.setUser(user);
		mgr.persist(b);
		return "Booking Confirmed Cash Wil be colllected on date " + sdate;
	}

	@Override
	public String addContactUs(ContactUs c) {
		mgr.persist(c);
		return "Your Comment Sent to Admin";
	}

	@Override
	public String changePassword(Integer id, String newpassword) {
		Users user = mgr.find(Users.class, id);
		user.setPassword(newpassword);
		return "Password Changed Successfully";
	}

	@Override
	public String addFeedBack(Feedback feedback1) {
		mgr.persist(feedback1);
		return "Feedback Saved Successfully";
	}

	@Override
	public void savePayment(Payment p) {

		mgr.persist(p);

	}

	@Override
	public String booktickets(Users user, Packages pac, String string, String discount, String sdate, String edate) {
		Bookings b = new Bookings();
		b.setAmountPaid(discount);
		b.setEnddate(edate);
		b.setStartdate(sdate);
		b.setPackage1(pac);
		b.setPaytype(string);
		b.setUser(user);
		mgr.persist(b);
		return "Booking Confirmed Enjoy your Ride";
	}

}
