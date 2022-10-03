package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AdminDaoInterface;
import com.app.pojos.Bookings;
import com.app.pojos.ContactUs;
import com.app.pojos.Feedback;
import com.app.pojos.Images;
import com.app.pojos.Packages;
import com.app.pojos.Users;

@Service
@Transactional
public class AdminService implements AdminServiceInterface {

	@Autowired
	private AdminDaoInterface adminDao;
	@Override
	public List<Feedback> fetchAllFeedback() {
		// TODO Auto-generated method stub
		return adminDao.fetchAllFeedback();
	}

	@Override
	public List<Bookings> fetchAllBooking() {
		// TODO Auto-generated method stub
		return adminDao.fetchAllBooking();
	}

	@Override
	public List<ContactUs> fetchAllContactUs() {
		// TODO Auto-generated method stub
		return adminDao.fetchAllContactUs();
	}

	@Override
	public List<Packages> fetchAllPackages() {
		// TODO Auto-generated method stub
		return adminDao.fetchAllPackages();
	}

	@Override
	public String addPackage(Packages package1) {
		// TODO Auto-generated method stub
		return adminDao.addPackage(package1);
	}

	@Override
	public String addImage(Images image1) {
		// TODO Auto-generated method stub
		return adminDao.addImage(image1);
	}

	@Override
	public List<Images> fetchAllImages() {
		// TODO Auto-generated method stub
		return adminDao.fetchAllImages();
	}

	@Override
	public String removeImage(int pid) {
		// TODO Auto-generated method stub
		return adminDao.removeImage(pid);
	}

	@Override
	public List<Feedback> fetchAllFeedBack() {
		// TODO Auto-generated method stub
		return adminDao.fetchAllFeedBack();
	}

	@Override
	public String deletePackage(int pid) {
		// TODO Auto-generated method stub
		return adminDao.deletePackage(pid);
	}

	@Override
	public List<Users> FetchUsers() {
		// TODO Auto-generated method stub
		return adminDao.FetchUsers();
	}

	@Override
	public Bookings fetchBookingById(int bid) {
		// TODO Auto-generated method stub
		return adminDao.fetchBookingById(bid);
	}

	@Override
	public String updatebooking(int bid, String startdate, String enddate) {
		// TODO Auto-generated method stub
		return adminDao.updatebooking(bid, startdate, enddate);
	}

}
