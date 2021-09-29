package com.nagarro.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.springmvc.dao.UserDao;
import com.nagarro.springmvc.model.User;

/**
 * This is a user layer,interacting between login controller and UserDao class
 *
 */
@Service
public class UserService {

	@Autowired
	private UserDao userdao;

	public int createUser(User user) {
		return this.userdao.saveUser(user);
	}

	public String validate(String email, String password) {

		// TODO Auto-generated method stub
		String flag;
		flag = userdao.validateData(email, password);

		return flag;
	}

}
