package com.nagarro.springmvc.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.springmvc.model.Employee;
import com.nagarro.springmvc.service.EmployeeService;
import com.nagarro.springmvc.service.UserService;



/**
 * This class is handling the data coming from log-in.jsp file.
 * 
 * @author Manjeet
 *
 */
@Controller
public class LoginController {

	@Autowired
	UserService userservice;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	HibernateTemplate hibernateTemplate;

	

	@RequestMapping("/log-in")
	public String showForm() {
		return "log-in";
	}
	
	
	@Transactional
	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public ModelAndView formHandler(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest req)
			throws ParseException {
		ModelAndView mv=new ModelAndView();
		String userName=userservice.validate(email, password);
		if (userName!=null) {
			HttpSession session=req.getSession();
			session.setAttribute("userName", userName);
			List<Employee> list= employeeService.getEmployee();
			mv.addObject("list", list);
			//mv.addObject("userName", userName);
			mv.setViewName("login-success");
			return mv;
		} else {
			mv.setViewName("login-fail");
			return mv;
		}
	}

}
