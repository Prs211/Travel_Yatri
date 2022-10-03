package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.LoginDaoInterfacee;
import com.app.pojos.Admin;
import com.app.pojos.Users;

@Service
@Transactional
public class LoginService implements LoginServiceInterface {

	@Autowired
	private LoginDaoInterfacee loginDao;

	@Override
	public Admin checkAdminAvailablity() {
		// TODO Auto-generated method stub
		return loginDao.checkAdminAvailablity();
	}

	@Override
	public void registerAdmin(Admin admin1) {
		// TODO Auto-generated method stub
		 loginDao.registerAdmin(admin1);
	}

	@Override
	public Users verifyUser(String email, String password) {
		// TODO Auto-generated method stub
		return loginDao.verifyUser(email, password);
	}

	@Override
	public Admin verifyAdmin(String email, String password) {
		// TODO Auto-generated method stub
		return loginDao.verifyAdmin(email, password);
	}

	@Override
	public boolean checkEmailAvailable(String email) {
		// TODO Auto-generated method stub
		return loginDao.checkEmailAvailable(email);
	}

	@Override
	public String registerUser(Users user) {
		// TODO Auto-generated method stub
		return loginDao.registerUser(user);
	}

	@Override
	public String changePassword(String email, String password) {
		// TODO Auto-generated method stub
		return loginDao.changePassword(email, password);
	}
}
