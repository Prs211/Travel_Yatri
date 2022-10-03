package com.app.service;

import java.util.List;

import com.app.pojos.Bookings;
import com.app.pojos.ContactUs;
import com.app.pojos.Feedback;
import com.app.pojos.Packages;
import com.app.pojos.Payment;
import com.app.pojos.Users;

public interface UserServiceInterface {

	List<Bookings> fetchmyBookings(Users user);

	Packages fetchPackageByID(int pid);

	String bookticket(Bookings book);

	String bookticket(Users user, Packages pac, String ptype, String discount, String sdate, String edate);

	String addContactUs(ContactUs c);

	String changePassword(Integer id, String newpassword);

	String addFeedBack(Feedback feedback1);

	void savePayment(Payment p);

	String booktickets(Users user, Packages pac, String string, String discount, String sdate, String edate);

}
