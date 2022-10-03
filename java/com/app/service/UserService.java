package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserDaoInterface;
import com.app.pojos.Bookings;
import com.app.pojos.ContactUs;
import com.app.pojos.Feedback;
import com.app.pojos.Packages;
import com.app.pojos.Payment;
import com.app.pojos.Users;

@Service
@Transactional
public class UserService implements UserServiceInterface {

	@Autowired
	private UserDaoInterface userDao;
	@Override
	public List<Bookings> fetchmyBookings(Users user) {
		// TODO Auto-generated method stub
		return userDao.fetchmyBookings(user);
	}
	@Override
	public Packages fetchPackageByID(int pid) {
		// TODO Auto-generated method stub
		return userDao.fetchPackageByID(pid);
	}
	@Override
	public String bookticket(Bookings book) {
		// TODO Auto-generated method stub
		return userDao.bookticket(book);
	}
	@Override
	public String bookticket(Users user, Packages pac, String ptype, String discount, String sdate, String edate) {
		// TODO Auto-generated method stub
		return userDao.bookticket(user, pac, ptype, discount, sdate, edate);
	}
	@Override
	public String addContactUs(ContactUs c) {
		// TODO Auto-generated method stub
		return userDao.addContactUs(c);
	}
	@Override
	public String changePassword(Integer id, String newpassword) {
		// TODO Auto-generated method stub
		return userDao.changePassword(id, newpassword);
	}
	@Override
	public String addFeedBack(Feedback feedback1) {
		// TODO Auto-generated method stub
		return userDao.addFeedBack(feedback1);
	}
	@Override
	public void savePayment(Payment p) {
		// TODO Auto-generated method stub
		userDao.savePayment(p);
	}
	@Override
	public String booktickets(Users user, Packages pac, String string, String discount, String sdate, String edate) {
		// TODO Auto-generated method stub
		return userDao.booktickets(user, pac, string, discount, sdate, edate);
	}

}
