package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Bookings;
import com.app.pojos.ContactUs;
import com.app.pojos.Feedback;
import com.app.pojos.Images;
import com.app.pojos.Packages;
import com.app.pojos.Users;

@Repository
public class AdminDao implements AdminDaoInterface {

	@Autowired
	private EntityManager mgr;
	
	@Override
	public List<Feedback> fetchAllFeedback() {
		try {
			String jpql="select a from Feedback a";
			List<Feedback> list=mgr.createQuery(jpql, Feedback.class).getResultList();
			if(list !=null)
				return list;
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<Bookings> fetchAllBooking() {
		try {
			String jpql="select a from Bookings a";
			List<Bookings> list=mgr.createQuery(jpql, Bookings.class).getResultList();
			if(list !=null)
				return list;
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<ContactUs> fetchAllContactUs() {
		try {
			String jpql="select a from ContactUs a";
			List<ContactUs> list=mgr.createQuery(jpql, ContactUs.class).getResultList();
			if(list !=null)
				return list;
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<Packages> fetchAllPackages() {
		try {
			String jpql="select a from Packages a";
			List<Packages> list=mgr.createQuery(jpql, Packages.class).getResultList();
			if(list !=null)
				return list;
			return null;
		} catch (Exception e) {
			return null;
		}
//SSO
	}

	@Override
	public String addPackage(Packages package1) {
		mgr.persist(package1);
		return "Package Inserted Successfully view and confirm";
	}

	@Override
	public String addImage(Images image1) {
		mgr.persist(image1);
		return "Image Saved Successfully";
	}

	@Override
	public List<Images> fetchAllImages() {
		String jpql="select i from Images i";
		return mgr.createQuery(jpql, Images.class).getResultList();
	}

	@Override
	public String removeImage(int pid) {
		Images image=mgr.find(Images.class, pid);
		mgr.remove(image);
		return "Image Removed Successfully";
	}

	@Override
	public List<Feedback> fetchAllFeedBack() {
		String jpql="select f from Feedback f";
		return mgr.createQuery(jpql, Feedback.class).getResultList();
	}

	@Override
	public String deletePackage(int pid) {
		Packages p=mgr.find(Packages.class, pid);
		mgr.remove(p);
		return "Package Removed Successfully";
	}

	@Override
	public List<Users> FetchUsers() {
		// TODO Auto-generated method stub
		return mgr.createQuery("select u from Users u", Users.class).getResultList();
	}

	@Override
	public Bookings fetchBookingById(int bid) {
		
		return mgr.find(Bookings.class, bid);
	}

	@Override
	public String updatebooking(int bid, String startdate, String enddate) {
		Bookings book=mgr.find(Bookings.class, bid);
		book.setStartdate(startdate);
		book.setEnddate(enddate);
		return "Booking Updated Successfully";
	}

}
