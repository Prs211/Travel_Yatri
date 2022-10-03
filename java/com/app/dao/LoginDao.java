package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Admin;
import com.app.pojos.Users;

@Repository
public class LoginDao implements LoginDaoInterfacee {

	@Autowired
	private EntityManager mgr;

	@Override
	public Admin checkAdminAvailablity() {
		try {
			String jpql = "select a from Admin a";
			Admin a = mgr.createQuery(jpql, Admin.class).getSingleResult();
			if (a != null)
				return a;
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void registerAdmin(Admin admin1) {
		mgr.persist(admin1);

	}

	@Override
	public Users verifyUser(String email, String password) {
		// TODO Auto-generated method stub
		try {
			String jpql = "select a from Users a where a.email=:email and a.password=:password";
			Users a = mgr.createQuery(jpql, Users.class).setParameter("email", email).setParameter("password", password)
					.getSingleResult();
			if (a != null)
				return a;
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public Admin verifyAdmin(String email, String password) {
		// TODO Auto-generated method stub
		try {
			String jpql = "select a from Admin a where a.email=:email and a.password=:password";
			Admin a = mgr.createQuery(jpql, Admin.class).setParameter("email", email).setParameter("password", password)
					.getSingleResult();
			if (a != null)
				return a;
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	@Override
	public boolean checkEmailAvailable(String email) {
		try {
			String jpql = "select a from Users a where a.email=:email";
			Users a = mgr.createQuery(jpql, Users.class).setParameter("email", email).getSingleResult();
			if (a != null)
				return false;
			return true;
		} catch (Exception e) {
			return true;
		}
	}

	@Override
	public String registerUser(Users user) {
		mgr.persist(user);
		return "Your Registration is done click on user icon to login";
	}

	@Override
	public String changePassword(String email, String password) {
		String jpql = "Select u from Users u where u.email=:email";
		Users user = mgr.createQuery(jpql, Users.class).setParameter("email", email).getSingleResult();
		user.setPassword(password);
		return "password changed Successfully";
	}
}
