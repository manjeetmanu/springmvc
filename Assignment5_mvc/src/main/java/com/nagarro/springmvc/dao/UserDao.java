package com.nagarro.springmvc.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.cj.xdevapi.SessionFactory;

import com.nagarro.springmvc.model.User;

//This class is used for accessing and update the data from database

@Repository
public class UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public int saveUser(User user) {
		int id = (Integer) this.hibernateTemplate.save(user);
		return id;
	}

	public String validateData(String email, String password) {

		// TODO Auto-generated method stub
		try {
			List<User> users = this.hibernateTemplate.loadAll(User.class);
			for (User user : users) {
				if (user.getEmail().equals(email) && user.getPassword().equals(password))
					return user.getUsername();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// get all products
	public List<User> getUsers() {
		List<User> users = this.hibernateTemplate.loadAll(User.class);
		return users;
	}

}
